package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.model.BenchmarksEntity;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.jboss.qa.monitoring.health.service.BenchmarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "api")
public class BenchmarksController {

    @Autowired
    private BenchmarksService benchmarksService;

    @PostMapping(value = "/updateBenchmarks", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BenchmarksEntity> updateBenchmarks(@RequestBody BenchmarksEntity benchmarksEntity) {
        benchmarksService.updateBenchmarks(benchmarksEntity);
        return new ResponseEntity<BenchmarksEntity>(benchmarksEntity, HttpStatus.OK);
    }
}
