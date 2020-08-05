package org.jboss.qa.monitoring.health.definitions;

    public enum CsvFileColumns {
        JOB("Job"),
        BENCHMARK("Benchmark"),
        SCORE("Score");

        private String column;

        CsvFileColumns(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }
    }


