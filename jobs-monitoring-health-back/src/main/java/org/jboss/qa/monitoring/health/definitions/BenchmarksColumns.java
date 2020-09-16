package org.jboss.qa.monitoring.health.definitions;

    public enum BenchmarksColumns {
        JOB("job"),
        BENCHMARK("benchmark"),
        PRODUCT("product"),
        BRANCH("branch"),
        SCORE("score"),
        SCORE_ERROR("scoreError");

        private String column;

        BenchmarksColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


