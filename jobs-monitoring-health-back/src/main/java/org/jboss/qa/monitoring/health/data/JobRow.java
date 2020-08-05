package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.JobColumns;
import org.json.simple.JSONObject;

public class JobRow {
    private String id;
    private int active;
    private String apiUrl;
    private String lastBuildApiUrl;

    public JobRow(JSONObject job) {
        if (job.get(JobColumns.ID.getColumn()) != null) {
            this.id = job.get(JobColumns.ID.getColumn()).toString();
        }
        if (job.get(JobColumns.ACTIVE.getColumn()) != null) {
            this.active = Integer.parseInt(job.get(JobColumns.ACTIVE.getColumn()).toString());
        }
        if (job.get(JobColumns.API_URL.getColumn()) != null) {
            this.apiUrl = job.get(JobColumns.API_URL.getColumn()).toString();
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
}
