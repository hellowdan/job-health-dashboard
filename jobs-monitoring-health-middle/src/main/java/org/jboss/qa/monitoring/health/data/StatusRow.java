package org.jboss.qa.monitoring.health.data;

import java.sql.Timestamp;

import org.jboss.qa.monitoring.health.definitions.JobStatus;
import org.jboss.qa.monitoring.health.definitions.StatusColumns;
import org.json.simple.JSONObject;

public class StatusRow {

    private String url;
    private String lastBuild;
    private String lastBuildNumber;
    private String lastSuccessfulBuild;
    private String lastSuccessfulBuildNumber;
    private String lastFailedBuild;
    private String lastFailedBuildNumber;
    private String lastBuildStatus;
    private int lastBuildStatusFlag;
    private String lastBuildDuration;
    private Timestamp lastBuildDateOfExecution;

    public StatusRow() {
    }

    public StatusRow(JSONObject statusRow) {
        if (statusRow.get(StatusColumns.URL.getColumn()) != null) {
            this.url = statusRow.get(StatusColumns.URL.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_BUILD.getColumn()) != null) {
            this.lastBuild = statusRow.get(StatusColumns.LAST_BUILD.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_BUILD_NUMBER.getColumn()) != null) {
            this.lastBuildNumber = statusRow.get(StatusColumns.LAST_BUILD_NUMBER.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn()) != null) {
            this.lastSuccessfulBuild = statusRow.get(StatusColumns.LAST_SUCCESSFUL_BUILD.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_SUCCESSFUL_BUILD_NUMBER.getColumn()) != null) {
            this.lastBuildNumber = statusRow.get(StatusColumns.LAST_SUCCESSFUL_BUILD_NUMBER.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_FAILED_BUILD.getColumn()) != null) {
            this.lastFailedBuild = statusRow.get(StatusColumns.LAST_FAILED_BUILD.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_FAILED_BUILD_NUMBER.getColumn()) != null) {
            this.lastBuildNumber = statusRow.get(StatusColumns.LAST_FAILED_BUILD_NUMBER.getColumn()).toString();
        }
        if (statusRow.get(StatusColumns.LAST_BUILD_STATUS.getColumn()) != null) {
            this.lastBuildStatus = statusRow.get(StatusColumns.LAST_BUILD_STATUS.getColumn()).toString();
            setLastBuildStatus();
        }
        if (statusRow.get(StatusColumns.LAST_BUILD_TIMESTAMP.getColumn()) != null) {
            Long lastBuildDateOfExecution = Long.parseLong(statusRow.get(StatusColumns.LAST_BUILD_TIMESTAMP.getColumn()).toString());
            this.lastBuildDateOfExecution = new Timestamp(lastBuildDateOfExecution);
        }
        if (statusRow.get(StatusColumns.LAST_BUILD_DURATION.getColumn()) != null) {
            this.lastBuildDuration = statusRow.get(StatusColumns.LAST_BUILD_DURATION.getColumn()).toString();
        }
    }

    public String getLastBuild() {
        return lastBuild;
    }

    public String getLastSuccessfulBuild() {
        return lastSuccessfulBuild;
    }

    public String getLastFailedBuild() {
        return lastFailedBuild;
    }

    public String getLastBuildStatus() {
        return lastBuildStatus;
    }

    public String getUrl() {
        return url;
    }

    public int getLastBuildStatusFlag() {
        return lastBuildStatusFlag;
    }

    public String getLastBuildDuration() {
        return lastBuildDuration;
    }

    public Timestamp getLastBuildDateOfExecution() {
        return lastBuildDateOfExecution;
    }

    public String getLastBuildNumber() {
        return lastBuildNumber;
    }

    public String getLastSuccessfulBuildNumber() {
        return lastSuccessfulBuildNumber;
    }

    public String getLastFailedBuildNumber() {
        return lastFailedBuildNumber;
    }

    public void setLastBuildStatus() {
        if (this.lastBuildStatus.equals(JobStatus.SUCCESS.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.SUCCESS.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.FAILURE.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.FAILURE.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.ABORTED.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.ABORTED.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.UNSTABLE.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.UNSTABLE.getStatusFlag();
        }
    }


    @Override
    public String toString() {
        return "StatusRow{" +
                "url='" + url + '\'' +
                "lastBuild='" + lastBuild + '\'' +
                "lastSuccessfulBuild='" + lastSuccessfulBuild + '\'' +
                "lastFailedBuild='" + lastFailedBuild + '\'' +
                "lastBuildStatus='" + lastBuildStatus + '\'' +
                "lastBuildStatusFlag='" + lastBuildStatusFlag + '\'' +
                "lastBuildDateOfExecution='" + lastBuildDateOfExecution + '\'' +
                '}';
    }
}
