package org.jboss.qa.monitoring.health.definitions;

    public enum BenchmarkColumns {
        JOB("job"),
        BENCHMARK("benchmark"),
        PRODUCT("product"),
        BRANCH("branch"),
        SCORE("score");

        private String column;

        BenchmarkColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


