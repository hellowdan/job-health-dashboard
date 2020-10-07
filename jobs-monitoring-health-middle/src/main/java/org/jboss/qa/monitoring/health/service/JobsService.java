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

    public void copyJobsFromBranch(String originBranch, String targetBranch){
        jobsRepository.findAll().forEach(e -> {
            if(e.getBranch().equals(originBranch)){
                JobsEntity jobsEntity = new JobsEntity();
                jobsEntity.setJob(e.getJob());
                jobsEntity.setProduct(e.getProduct());
                jobsEntity.setBranch(targetBranch);
                jobsEntity.setFolder(e.getFolder());
                jobsEntity.setSchedule(e.getSchedule());
                jobsEntity.setSubfolder(e.getSubfolder());
                jobsEntity.setUrl(e.getUrl().replace(originBranch, targetBranch));
                jobsEntity.setApiUrl(e.getApiUrl().replace(originBranch, targetBranch));
                jobsEntity.setLastBuildApiUrl(e.getLastBuildApiUrl().replace(originBranch, targetBranch));
                jobsEntity.setActive(1);

                saveJob(jobsEntity);
            }
        });
    }

    public void changeBranchActivation(String branch, String active) {
        jobsRepository.findAll().forEach(e -> {
            if(e.getBranch().equals(branch)){
                e.setActive(Integer.parseInt(active));

                saveJob(e);
            }
        });
    }

}
