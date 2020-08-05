package org.jboss.qa.monitoring.health.definitions;

public enum JobStatus {
    SUCCESS("SUCCESS", 2),
    UNSTABLE("UNSTABLE", 1),
    ABORTED("ABORTED", 0),
    FAILURE("FAILURE", -1);

    private String status;
    private int statusFlag;

    JobStatus(String status, int statusFlag) {
        this.status = status;
        this.statusFlag = statusFlag;
    }

    public String getStatus() {
        return status;
    }

    public int getStatusFlag() {
        return statusFlag;
    }
}
