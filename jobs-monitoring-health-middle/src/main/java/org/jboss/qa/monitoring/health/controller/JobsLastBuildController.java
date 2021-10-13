package org.jboss.qa.monitoring.health.controller;

import java.util.List;

import org.jboss.qa.monitoring.health.model.JobsLastBuildEntity;
import org.jboss.qa.monitoring.health.service.JobsLastBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping(value = "api")
public class JobsLastBuildController {

    @Autowired
    private JobsLastBuildService jobsLastBuildService;

    @GetMapping(value = "getJobLastBuild/{id}")
    public ResponseEntity<JobsLastBuildEntity> getJobLastBuild(@PathVariable("id") int id) {
        try {
            JobsLastBuildEntity jobsLastBuildEntity = jobsLastBuildService.getJobById(id);
            return new ResponseEntity<JobsLastBuildEntity>(jobsLastBuildEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<JobsLastBuildEntity>(new JobsLastBuildEntity(), HttpStatus.NOT_FOUND);
        }
    }
}
