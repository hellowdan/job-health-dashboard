package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.service.BenchmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        String result = benchmarksService.updateBenchmarks();

        if (result.equals("SUCCESS")) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
        } else {
            headers.add("FAIL", result);
            return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
        }
    }

}
