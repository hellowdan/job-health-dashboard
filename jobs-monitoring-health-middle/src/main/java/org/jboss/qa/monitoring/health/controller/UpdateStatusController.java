package org.jboss.qa.monitoring.health.controller;

import org.jboss.qa.monitoring.health.data.StatusData;
import org.jboss.qa.monitoring.health.definitions.StatusColumns;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.jboss.qa.monitoring.health.service.JobsService;
import org.json.simple.JSONObject;
import org.jboss.qa.monitoring.health.model.StatusEntity;
import org.jboss.qa.monitoring.health.service.UpdateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class UpdateStatusController {

    @Autowired
    private UpdateStatusService updateStatusService;

    @Autowired
    private JobsService jobsService;

    private JobsEntity jobsEntity;

    @PostMapping(value = "/updateStatus", consumes = "application/json", produces = "application/json")
    public String updateStatus(@RequestBody JSONObject jobsDailyStatus) {
        String jobId = "";
        if (jobsDailyStatus.get(StatusColumns.JOB_ID.getColumn()) != null) {
            jobId = jobsDailyStatus.get(StatusColumns.JOB_ID.getColumn()).toString();
            this.jobsEntity = jobsService.getJobById(jobId);

            StatusData statusData = new StatusData();
            StatusEntity statusEntity = statusData.getParsedStatusData(jobsDailyStatus, this.jobsEntity);
            updateStatusService.updateStatus(statusEntity);

            return "SUCCESS";
        } else return "FAIL";
    }

}
