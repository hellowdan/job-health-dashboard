package org.jboss.qa.monitoring.health.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.qa.monitoring.health.data.BenchmarksRow;
import org.jboss.qa.monitoring.health.data.JobRow;
import org.jboss.qa.monitoring.health.definitions.BenchmarksColumns;
import org.jboss.qa.monitoring.health.definitions.CsvFileColumns;
import org.jboss.qa.monitoring.health.util.CsvLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BenchmarksService {

    @Autowired
    private RestTemplate restTemplate;

    private String URI_ALL_JOBS = "http://jobs-health-monitoring-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com/api/jobs";
    private String URI_UPDATE_STATUS = "http://jobs-health-monitoring-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com/api/updateBenchmarks";

    public String updateBenchmarks() {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);

        dataJobs.forEach(jsonObject -> {

            JobRow jobRow = new JobRow(jsonObject);

            if ((jobRow.getActive() > 0) && (jobRow.getFolder().equals("RHDM-benchmarks"))) {
                try {
                    List<BenchmarksRow> benchmarksRows = getCsvData(jobRow.getLastBuildResultFile(), jobRow);

                    benchmarksRows.forEach(b -> {
                        try {
                            postJsonContent(URI_UPDATE_STATUS, b);
                        } catch (URISyntaxException e) {
                            result.set(e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    result.set(e.getMessage());
                }
            }
        });

        return result.get();
    }

    public void postJsonContent(String url, BenchmarksRow benchmarksRow) throws URISyntaxException {
        URI uri = new URI(url);

        JSONObject jsonData = new JSONObject();
        jsonData.put(BenchmarksColumns.JOB.getColumn(), benchmarksRow.getJob());
        jsonData.put(BenchmarksColumns.BENCHMARK.getColumn(), benchmarksRow.getBenchmark());
        jsonData.put(BenchmarksColumns.BRANCH.getColumn(), benchmarksRow.getBranch());
        jsonData.put(BenchmarksColumns.PRODUCT.getColumn(), benchmarksRow.getProduct());
        jsonData.put(BenchmarksColumns.SCORE.getColumn(), benchmarksRow.getScore());

        ResponseEntity<String> result = restTemplate.postForEntity(uri, jsonData, String.class);
    }

    public JSONObject getJsonContent(String url) {
        return this.restTemplate.getForObject(url, JSONObject.class);
    }

    public List<JSONObject> getJsonNestedContent(String url) {
        JSONObject[] result = this.restTemplate.getForObject(url, JSONObject[].class);
        return Arrays.asList(result);
    }

    public List<BenchmarksRow> getCsvData(String filePath, JobRow jobRow) throws IOException, ParseException {
        List<BenchmarksRow> benchmarksRows = new ArrayList<>();
        JSONArray dataJson;

        CsvLoader csvLoader = new CsvLoader();
        dataJson = csvLoader.getDataFromCSV(filePath);

        dataJson.forEach(resultRow -> benchmarksRows.add(parseReportRow((JSONObject) resultRow, jobRow)));

        return benchmarksRows;
    }

    protected BenchmarksRow parseReportRow(JSONObject reportRow, JobRow jobRow) {
        BenchmarksRow benchmarksRow = new BenchmarksRow();

        benchmarksRow.setJob(jobRow.getJob());
        benchmarksRow.setBranch(jobRow.getBranch());
        benchmarksRow.setProduct(jobRow.getProduct());

        if (reportRow.get(CsvFileColumns.BENCHMARK.getColumn()) != null) {
            benchmarksRow.setBenchmark((String) reportRow.get(CsvFileColumns.BENCHMARK.getColumn()));
        }
        if (reportRow.get(CsvFileColumns.SCORE.getColumn()) != null) {
            benchmarksRow.setScore(reportRow.get(CsvFileColumns.SCORE.getColumn()).toString());
        }

        return benchmarksRow;
    }
}
