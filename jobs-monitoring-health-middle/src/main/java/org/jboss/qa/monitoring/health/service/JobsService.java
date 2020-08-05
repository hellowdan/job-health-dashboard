package org.jboss.qa.monitoring.health.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.qa.monitoring.health.dao.JobsRepository;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService {

    @Autowired
    JobsRepository jobsRepository;

    public List<JobsEntity> getAllJobs(){
        List<JobsEntity> jobsEntities = new ArrayList<>();
        jobsRepository.findAll().forEach(e -> jobsEntities.add(e));
        return jobsEntities;
    }

    public JobsEntity getJobById(long jobsStatusId) {
        JobsEntity jobsEntity = jobsRepository.findById(jobsStatusId).get();
        return jobsEntity;
    }

    public JobsEntity getJobById(String jobsStatusId) {
        long jobId = Long.parseLong(jobsStatusId);
        return getJobById(jobId);
    }

    public void saveJob(JobsEntity jobsEntity) {
        jobsRepository.save(jobsEntity);
    }

    public void deleteJob(int jobsId) {
        jobsRepository.delete(getJobById(jobsId));
    }

}
