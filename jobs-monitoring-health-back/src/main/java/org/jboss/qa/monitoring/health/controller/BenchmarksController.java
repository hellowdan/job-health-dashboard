package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.definitions.ScheduleType;
import org.jboss.qa.monitoring.health.service.BenchmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class BenchmarksController {

    @Autowired
    private BenchmarksService benchmarksService;

    @PostMapping(value = "/updateBenchmarks")
    public ResponseEntity<Void> updateBenchmarks() {
        HttpHeaders headers = new HttpHeaders();

        String result = benchmarksService.updateOnlyNewBuilds();

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAILED", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/forceUpdateBenchmarks")
    public ResponseEntity<Void> forceUpdateBenchmarks() {
        HttpHeaders headers = new HttpHeaders();

        String result = benchmarksService.updateAllBenchmarks();

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAILED", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/updateBenchmark/{job}")
    public ResponseEntity<Void> updateBenchmark(@PathVariable("job") String job) {
        HttpHeaders headers = new HttpHeaders();

        String result = benchmarksService.updateBenchmark(job);

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAILED", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/updateBenchmarks/nightly")
    public ResponseEntity<Void> updateNightlyBenchmarks() {
        HttpHeaders headers = new HttpHeaders();

        String result = benchmarksService.updateBenchmarks(ScheduleType.NIGHTLY);

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAILED", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/updateBenchmarks/weekly")
    public ResponseEntity<Void> updateWeeklyBenchmarks() {
        HttpHeaders headers = new HttpHeaders();

        String result = benchmarksService.updateBenchmarks(ScheduleType.WEEKLY);

        if (result.contains("SUCCESS")) {
            headers.add("SUCCESS", result);
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAILED", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }
}
