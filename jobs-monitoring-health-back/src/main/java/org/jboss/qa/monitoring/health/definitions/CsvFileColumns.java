package org.jboss.qa.monitoring.health.definitions;

    public enum CsvFileColumns {
        JOB("Job"),
        BENCHMARK("Benchmark"),
        SCORE("Score"),
        SCORE_ERROR("Score Error (99.9%)");

        private String column;

        CsvFileColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


