package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.JobColumns;
import org.json.simple.JSONObject;

public class JobRow {

    private String id;
    private String job;
    private int active;
    private String folder;
    private String product;
    private String branch;
    private String schedule;
    private String subfolder;
    private String apiUrl;
    private String lastBuildApiUrl;
    private String lastBuildResultFile;

    public JobRow() {
    }

    public void parseJobRow(JSONObject job) {
        if (job.get(JobColumns.ID.getColumn()) != null) {
            this.id = job.get(JobColumns.ID.getColumn()).toString();
        }
        if (job.get(JobColumns.JOB.getColumn()) != null) {
            this.job = job.get(JobColumns.JOB.getColumn()).toString();
        }
        if (job.get(JobColumns.ACTIVE.getColumn()) != null) {
            this.active = Integer.parseInt(job.get(JobColumns.ACTIVE.getColumn()).toString());
        }
        if (job.get(JobColumns.FOLDER.getColumn()) != null) {
            this.folder = job.get(JobColumns.FOLDER.getColumn()).toString();
        }
        if (job.get(JobColumns.PRODUCT.getColumn()) != null) {
            this.product = job.get(JobColumns.PRODUCT.getColumn()).toString();
        }
        if (job.get(JobColumns.BRANCH.getColumn()) != null) {
            this.branch = job.get(JobColumns.BRANCH.getColumn()).toString();
        }
        if (job.get(JobColumns.SUBFOLDER.getColumn()) != null) {
            this.subfolder = job.get(JobColumns.SUBFOLDER.getColumn()).toString();
        }
        if (job.get(JobColumns.SCHEDULE.getColumn()) != null) {
            this.schedule = job.get(JobColumns.SCHEDULE.getColumn()).toString();
        }
        if (job.get(JobColumns.API_URL.getColumn()) != null) {
            this.apiUrl = job.get(JobColumns.API_URL.getColumn()).toString();

            int index = this.apiUrl.indexOf("api/json");
            String jobSimplePath = this.apiUrl.substring(0, index);
            this.lastBuildResultFile = jobSimplePath + "/lastSuccessfulBuild/artifact/kie-benchmarks/results.csv";
        }
        if (job.get(JobColumns.LAST_BUILD_API_URL.getColumn()) != null) {
            this.lastBuildApiUrl = job.get(JobColumns.LAST_BUILD_API_URL.getColumn()).toString();
        }
    }

    public String getId() {
        return id;
    }

    public int getActive() {
        return active;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getLastBuildApiUrl() {
        return lastBuildApiUrl;
    }

    public String getFolder() {
        return folder;
    }

    public String getLastBuildResultFile() {
        return lastBuildResultFile;
    }

    public String getJob() {
        return job;
    }

    public String getProduct() {
        return product;
    }

    public String getBranch() {
        return branch;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getSubfolder() {
        return subfolder;
    }
}
