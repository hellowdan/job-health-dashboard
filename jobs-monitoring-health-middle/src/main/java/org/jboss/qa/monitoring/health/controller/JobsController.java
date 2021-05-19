package org.jboss.qa.monitoring.health.controller;

import java.util.List;

import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.jboss.qa.monitoring.health.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping(value = "api")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @GetMapping(value = "jobs")
    public ResponseEntity<List<JobsEntity>> getAllJobs() {
        List<JobsEntity> jobsEntityList = jobsService.getAllJobs();
        return new ResponseEntity<List<JobsEntity>>(jobsEntityList, HttpStatus.OK);
    }

    @GetMapping(value = "job/{id}")
    public ResponseEntity<JobsEntity> getJob(@PathVariable("id") int id) {
        JobsEntity jobsEntity = jobsService.getJobById(id);
        return new ResponseEntity<JobsEntity>(jobsEntity, HttpStatus.OK);
    }

    @PostMapping(value = "add-job", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> addJob(@RequestBody JobsEntity jobsEntity, UriComponentsBuilder builder) {
        jobsService.saveJob(jobsEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/job/{id}").buildAndExpand(jobsEntity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public String connectionTest() {
        return "Success!";
    }

    @DeleteMapping("delete-job/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable("id") int id) {
        jobsService.deleteJob(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(value = "/update-job/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<JobsEntity> updateJob(@RequestBody JobsEntity jobsEntity, @PathVariable("id") int id, UriComponentsBuilder builder) {
        jobsService.saveJob(id, jobsEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/job/{id}").buildAndExpand(jobsEntity.getId()).toUri());
        return new ResponseEntity<JobsEntity>(headers, HttpStatus.OK);
    }

    @GetMapping(value = "add-branch/origin/{originBranch}/target/{targetBranch}/replacedValuesInUrl/{replacedValuesInUrl}/newValuesInUrl/{newValuesInUrl}")
    public ResponseEntity<Void> addBranch(@PathVariable("originBranch") String originBranch,
                                          @PathVariable("targetBranch") String targetBranch,
                                          @PathVariable("replacedValuesInUrl") String replacedValuesInUrl,
                                          @PathVariable("newValuesInUrl") String newValuesInUrl) {
        jobsService.copyJobsFromBranch(originBranch, targetBranch, replacedValuesInUrl, newValuesInUrl);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/activate-branch/{branch}")
    public ResponseEntity<Void> activateBranch(@PathVariable("branch") String branch) {
        jobsService.changeBranchActivation(branch, "1");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/deactivate-branch/{branch}")
    public ResponseEntity<Void> deactivateBranch(@PathVariable("branch") String branch) {
        jobsService.changeBranchActivation(branch, "0");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
