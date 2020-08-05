package org.jboss.qa.monitoring.health.definitions;

    public enum StatusColumns {
        JOB_ID("jobId"),
        JOB("fullDisplayName"),
        URL("url"),
        LAST_BUILD("lastCompletedBuild"),
        LAST_SUCCESSFUL_BUILD("lastSuccessfulBuild"),
        LAST_FAILED_BUILD("lastFailedBuild"),
        LAST_BUILD_STATUS("result"),
        LAST_BUILD_TIMESTAMP("timestamp"),
        LAST_BUILD_DURATION("duration"),
        BUILD_NUMBER("number");

        private String column;

        StatusColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


