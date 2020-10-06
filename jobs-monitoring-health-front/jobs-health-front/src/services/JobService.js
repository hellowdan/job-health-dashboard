import axios from 'axios';

const JOB_API_BASE_URL = "https://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com/api";

class JobService {

    getJobs(){
        return axios.get(JOB_API_BASE_URL + '/jobs');
    }

    addJob(Job){
        return axios.post(JOB_API_BASE_URL + '/add-job', Job);
    }

    getJobById(JobId){
        return axios.get(JOB_API_BASE_URL + '/job/' + JobId);
    }

    // updateJob(Job, JobId){
    //     return axios.put(JOB_API_BASE_URL + '/update-job/' + JobId, Job);
    // }

    // deleteJob(JobId){
    //     return axios.delete(JOB_API_BASE_URL + '/delete-job/' + JobId);
    // }
}

export default new JobService()