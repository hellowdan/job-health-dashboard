package org.jboss.qa.monitoring.health.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.qa.monitoring.health.data.JobRow;
import org.jboss.qa.monitoring.health.definitions.StatusColumns;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatusService {

    @Autowired
    private RestTemplate restTemplate;

    private String URI_ALL_JOBS = "http://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com/api/jobs";
    private String URI_UPDATE_STATUS = "http://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com/api/updateStatus";

    private String updateStatusJob(JobRow jobRow){
        String result = "";

        if (jobRow.getActive() > 0) {
            try {
                result = jobRow.getJob() + ":" + "EMPTY";

                JSONObject dataJsonLastBuild = getJsonContent(jobRow.getLastBuildApiUrl());
                JSONObject dataJsonJob = getJsonContent(jobRow.getApiUrl());

                boolean hasError = ((dataJsonLastBuild.containsKey("Error")) || (dataJsonJob.containsKey("Error")));

                if (!hasError) {
                    JSONObject dataJSON = mergeJSONObjects(dataJsonLastBuild, dataJsonJob, jobRow.getId());
                    postJsonContent(URI_UPDATE_STATUS, dataJSON);
                    result = jobRow.getJob() + ":" + "SUCCESS";
                }
            } catch (URISyntaxException e) {
                result = jobRow.getJob() + ":" + e.getMessage();
            }
        }

        return result;
    }

    public String updateStatus(String job) {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);
        ArrayList<String> results = new ArrayList<String>();

        for (int i=0; i<dataJobs.size(); i++) {
            JobRow jobRow = new JobRow();
            jobRow.parseJobRow(dataJobs.get(i));

            if(jobRow.getJob().equals(job)) {
                results.add(updateStatusJob(jobRow));
            }
        };

        result.set(formatResults(results));
        return result.get();
    }

    public String updateStatusSubfolder(String subfolder) {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);
        ArrayList<String> results = new ArrayList<String>();

        for (int i=0; i<dataJobs.size(); i++) {
            JobRow jobRow = new JobRow();
            jobRow.parseJobRow(dataJobs.get(i));

            if(jobRow.getSubfolder().equals(subfolder)) {
                results.add(updateStatusJob(jobRow));
            }
        };

        result.set(formatResults(results));
        return result.get();
    }

    public String updateStatus() {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);
        ArrayList<String> results = new ArrayList<String>();

        dataJobs.forEach(jsonObject -> {
            JobRow jobRow = new JobRow();
            jobRow.parseJobRow(jsonObject);

            results.add(updateStatusJob(jobRow));
        });

        result.set(formatResults(results));
        return result.get();
    }

    private String formatResults(ArrayList<String> results){
        String finalResult = "";

        for (String s : results) {
            if(!s.isEmpty()) {
                finalResult += s + "\t";
            }
        }

        return finalResult;
    }

    private void postJsonContent(String url, JSONObject dataJSON) throws URISyntaxException {
        URI uri = new URI(url);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, dataJSON, String.class);
    }

    private JSONObject getJsonContent(String url) {
        try {
            return this.restTemplate.getForObject(url, JSONObject.class);
        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("Error", e.getMessage());
            return error;
        }
    }

    private List<JSONObject> getJsonNestedContent(String url) {
        try {
            JSONObject[] result = this.restTemplate.getForObject(url, JSONObject[].class);
            return Arrays.asList(result);
        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("Error", e.getMessage());
            return Arrays.asList(error);
        }
    }

    private JSONObject mergeJSONObjects(JSONObject dataJsonLastBuild, JSONObject dataJsonJob, String jobId) {
        JSONObject result = new JSONObject();

        result.put(StatusColumns.JOB_ID.getColumn(), jobId);

        if (dataJsonLastBuild.get(StatusColumns.URL.getColumn()) != null) {
            result.put(StatusColumns.URL.getColumn(), dataJsonLastBuild.get(StatusColumns.URL.getColumn()).toString());
        }
        if (dataJsonJob.get(StatusColumns.LAST_BUILD.getColumn()) != null) {
            result.put(StatusColumns.LAST_BUILD.getColumn(), dataJsonJob.get(StatusColumns.LAST_BUILD.getColumn()).toString());
            LinkedHashMap resultNumber = (LinkedHashMap) dataJsonJob.get(StatusColumns.LAST_BUILD.getColumn());
            String number = resultNumber.get(StatusColumns.BUILD_NUMBER.getColumn()).toString();
            result.put(StatusColumns.LAST_BUILD_NUMBER.getColumn(), number);
        }
        if (dataJsonJob.get(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn()) != null) {
            result.put(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn(), dataJsonJob.get(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn()).toString());
            LinkedHashMap resultNumber = (LinkedHashMap) dataJsonJob.get(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn());
            String number = resultNumber.get(StatusColumns.BUILD_NUMBER.getColumn()).toString();
            result.put(StatusColumns.LAST_SUCCESSFUL_BUILD_NUMBER.getColumn(), number);
        }
        if (dataJsonJob.get(StatusColumns.LAST_FAILED_BUILD.getColumn()) != null) {
            result.put(StatusColumns.LAST_FAILED_BUILD.getColumn(), dataJsonJob.get(StatusColumns.LAST_FAILED_BUILD.getColumn()).toString());
            LinkedHashMap resultNumber = (LinkedHashMap) dataJsonJob.get(StatusColumns.LAST_FAILED_BUILD.getColumn());
            String number = resultNumber.get(StatusColumns.BUILD_NUMBER.getColumn()).toString();
            result.put(StatusColumns.LAST_FAILED_BUILD_NUMBER.getColumn(), number);
        }
        if (dataJsonLastBuild.get(StatusColumns.LAST_BUILD_STATUS.getColumn()) != null) {
            result.put(StatusColumns.LAST_BUILD_STATUS.getColumn(), dataJsonLastBuild.get(StatusColumns.LAST_BUILD_STATUS.getColumn()).toString());
        }
        if (dataJsonLastBuild.get(StatusColumns.LAST_BUILD_TIMESTAMP.getColumn()) != null) {
            result.put(StatusColumns.LAST_BUILD_TIMESTAMP.getColumn(), dataJsonLastBuild.get(StatusColumns.LAST_BUILD_TIMESTAMP.getColumn()).toString());
        }
        if (dataJsonLastBuild.get(StatusColumns.LAST_BUILD_DURATION.getColumn()) != null) {
            result.put(StatusColumns.LAST_BUILD_DURATION.getColumn(), dataJsonLastBuild.get(StatusColumns.LAST_BUILD_DURATION.getColumn()).toString());
        }

        return result;
    }
}
