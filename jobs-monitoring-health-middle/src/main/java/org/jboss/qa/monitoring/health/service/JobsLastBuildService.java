package org.jboss.qa.monitoring.health.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.qa.monitoring.health.dao.JobsLastBuildRepository;
import org.jboss.qa.monitoring.health.model.JobsLastBuildEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsLastBuildService {

    @Autowired
    JobsLastBuildRepository jobsLastBuildRepository;

    public List<JobsLastBuildEntity> getAllJobs(){
        List<JobsLastBuildEntity> jobsLastBuildEntities = new ArrayList<>();
        jobsLastBuildRepository.findAll().forEach(e -> jobsLastBuildEntities.add(e));
        return jobsLastBuildEntities;
    }

    public JobsLastBuildEntity getJobById(long jobsId) {
        JobsLastBuildEntity jobsLastBuildEntity = jobsLastBuildRepository.findById(jobsId).get();
        return jobsLastBuildEntity;
    }

    public JobsLastBuildEntity getJobById(String jobsId) {
        long jobId = Long.parseLong(jobsId);
        return getJobById(jobId);
    }



}
