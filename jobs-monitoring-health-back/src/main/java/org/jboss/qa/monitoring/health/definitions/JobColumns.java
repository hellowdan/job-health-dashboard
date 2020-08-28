package org.jboss.qa.monitoring.health.definitions;

    public enum JobColumns {
        ID("id"),
        JOB("job"),
        ACTIVE("active"),
        FOLDER("folder"),
        PRODUCT("product"),
        BRANCH("branch"),
        SUBFOLDER("subfolder"),
        SCHEDULE("schedule"),
        API_URL("apiUrl"),
        LAST_BUILD_API_URL("lastBuildApiUrl");

        private String column;

        JobColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


