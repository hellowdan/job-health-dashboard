package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.definitions.BenchmarkColumns;
import org.jboss.qa.monitoring.health.model.BenchmarksEntity;
import org.jboss.qa.monitoring.health.service.BenchmarksService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class BenchmarksController {

    @Autowired
    private BenchmarksService benchmarksService;

    @PostMapping(value = "/updateBenchmarks", consumes = "application/json", produces = "application/json")
    public String updateBenchmarks(@RequestBody JSONObject benchmarkData) {

        if (benchmarkData.get(BenchmarkColumns.JOB.getColumn()) != null) {
            BenchmarksEntity benchmarksEntity = getBenchmarkEntity(benchmarkData);

            benchmarksService.updateBenchmarks(benchmarksEntity);

            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    private BenchmarksEntity getBenchmarkEntity(JSONObject benchmarkData) {
        String job = "";
        String benchmark = "";
        String product = "";
        String branch = "";
        String score = "";

        if (benchmarkData.get(BenchmarkColumns.JOB.getColumn()) != null) {
            job = benchmarkData.get(BenchmarkColumns.JOB.getColumn()).toString();
        }
        if (benchmarkData.get(BenchmarkColumns.BENCHMARK.getColumn()) != null) {
            benchmark = benchmarkData.get(BenchmarkColumns.BENCHMARK.getColumn()).toString();
        }
        if (benchmarkData.get(BenchmarkColumns.PRODUCT.getColumn()) != null) {
            product = benchmarkData.get(BenchmarkColumns.PRODUCT.getColumn()).toString();
        }
        if (benchmarkData.get(BenchmarkColumns.BRANCH.getColumn()) != null) {
            branch = benchmarkData.get(BenchmarkColumns.BRANCH.getColumn()).toString();
        }
        if (benchmarkData.get(BenchmarkColumns.SCORE.getColumn()) != null) {
            score = benchmarkData.get(BenchmarkColumns.SCORE.getColumn()).toString();
        }

        return new BenchmarksEntity(job, benchmark, product, branch, score);
    }
}
