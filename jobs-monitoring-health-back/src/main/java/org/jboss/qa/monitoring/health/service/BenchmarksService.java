package org.jboss.qa.monitoring.health.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.jboss.qa.monitoring.health.data.BenchmarksRow;
import org.jboss.qa.monitoring.health.data.BuildtimeRow;
import org.jboss.qa.monitoring.health.data.CepRow;
import org.jboss.qa.monitoring.health.data.DmnRow;
import org.jboss.qa.monitoring.health.data.JobRow;
import org.jboss.qa.monitoring.health.data.OopathRow;
import org.jboss.qa.monitoring.health.data.OperatorsRow;
import org.jboss.qa.monitoring.health.data.RuntimeRow;
import org.jboss.qa.monitoring.health.data.SessionRow;
import org.jboss.qa.monitoring.health.definitions.BenchmarkTypes;
import org.jboss.qa.monitoring.health.definitions.BenchmarksColumns;
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

    private String URI_ALL_JOBS = "http://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com//api/jobs";
    private String URI_UPDATE_BENCHMARKS = "http://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com//api/updateBenchmarks";

    public String updateBenchmarks() {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);

        dataJobs.forEach(jsonObject -> {

            JobRow jobRow = new JobRow();
            jobRow.parseJobRow(jsonObject);

            if ((jobRow.getActive() > 0) && (jobRow.getFolder().equals("RHDM-benchmarks"))) {
                try {
                    BenchmarkTypes benchmarkType = BenchmarkTypes.getColumn(jobRow.getJob());

                    if (CsvLoader.isUrlReachable(jobRow.getLastBuildResultFile())) {
                        JSONArray dataJson = getJsonData(jobRow.getLastBuildResultFile());
                        List<BenchmarksRow> benchmarksRows = getCsvData(benchmarkType, dataJson, jobRow);

                        boolean hasError = benchmarksRows.size() == 0;

                        if (!hasError) {
                            benchmarksRows.forEach(b -> {
                                try {
                                    postJsonContent(URI_UPDATE_BENCHMARKS, b);
                                } catch (URISyntaxException e) {
                                    result.set(e.getMessage());
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    result.set(e.getMessage());
                }
            }
        });

        return result.get();
    }

    public String updateBenchmark(String benchmark) {
        AtomicReference<String> result = new AtomicReference<>("SUCCESS");
        List<JSONObject> dataJobs = getJsonNestedContent(URI_ALL_JOBS);

        dataJobs.forEach(jsonObject -> {

            JobRow jobRow = new JobRow();
            jobRow.parseJobRow(jsonObject);

            if ((jobRow.getActive() > 0) && (jobRow.getFolder().equals("RHDM-benchmarks"))
                    && (jobRow.getJob().equals(benchmark))) {
                try {
                    BenchmarkTypes benchmarkType = BenchmarkTypes.getColumn(jobRow.getJob());

                    if (CsvLoader.isUrlReachable(jobRow.getLastBuildResultFile())) {
                        JSONArray dataJson = getJsonData(jobRow.getLastBuildResultFile());
                        List<BenchmarksRow> benchmarksRows = getCsvData(benchmarkType, dataJson, jobRow);

                        boolean hasError = benchmarksRows.size() == 0;

                        if (!hasError) {
                            benchmarksRows.forEach(b -> {
                                try {
                                    postJsonContent(URI_UPDATE_BENCHMARKS, b);
                                } catch (URISyntaxException e) {
                                    result.set(e.getMessage());
                                }
                            });
                        }
                    }
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

    public List<JSONObject> getJsonNestedContent(String url) {
        try {
            JSONObject[] result = this.restTemplate.getForObject(url, JSONObject[].class);
            return Arrays.asList(result);
        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("Error", e.getMessage());
            return Arrays.asList(error);
        }
    }

    public JSONArray getJsonData(String filePath) {
        CsvLoader csvLoader = new CsvLoader();
        try {
            return csvLoader.getDataFromCSV(filePath);
        } catch (IOException e) {
            return null;
        } catch (ParseException e) {
            return null;
        }
    }

    public List<BenchmarksRow> getCsvData(BenchmarkTypes benchmarkType, JSONArray dataJson, JobRow jobRow) {
        List<BenchmarksRow> benchmarksRows = new ArrayList<>();

        dataJson.forEach(resultRow -> {
            BenchmarksRow benchmarksRow = null;
            switch (benchmarkType) {
                case DMN:
                    benchmarksRow = new DmnRow();
                    break;
                case EVENT_PROCESSING:
                    benchmarksRow = new CepRow(false);
                    break;
                case EVENT_PROCESSING_MULTITHREADED:
                    benchmarksRow = new CepRow(true);
                    break;
                case OOPATH:
                    benchmarksRow = new OopathRow();
                    break;
                case OPERATORS:
                    benchmarksRow = new OperatorsRow();
                    break;
                case SESSION:
                    benchmarksRow = new SessionRow();
                    break;
                case BUILDTIME:
                    benchmarksRow = new BuildtimeRow();
                    break;
                case RUNTIME:
                    benchmarksRow = new RuntimeRow(false);
                    break;
                case RUNTIME_MULTITHREADED:
                    benchmarksRow = new RuntimeRow(true);
                    break;
            }

            benchmarksRow.parseReportRow((JSONObject) resultRow, jobRow);
            benchmarksRows.add(benchmarksRow);
        });
        return benchmarksRows;
    }
}
