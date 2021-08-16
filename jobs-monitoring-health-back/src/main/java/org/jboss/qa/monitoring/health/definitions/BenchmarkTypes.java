package org.jboss.qa.monitoring.health.definitions;

    public enum BenchmarkTypes {
        DMN("perf-dmn-benchmarks"),
        EVENT_PROCESSING("perf-event-processing-benchmarks"),
        EVENT_PROCESSING_MULTITHREADED("perf-event-processing-multithreaded-benchmarks"),
        OOPATH("perf-oopath-benchmarks"),
        OPERATORS("perf-operators-benchmarks"),
        SESSION("perf-session-benchmarks"),
        BUILDTIME("perf-turtle-buildtime-benchmarks"),
        RUNTIME("perf-turtle-runtime-benchmarks"),
        RUNTIME_MULTITHREADED("perf-turtle-runtime-multithreaded-benchmarks"),
        //JBPM
        JBPM("jbpm-perf-jmh");

        private String column;

        BenchmarkTypes(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }

        public static BenchmarkTypes getColumn(String column) {
            for (BenchmarkTypes benchmarkTypes : BenchmarkTypes.values()) {
                if (benchmarkTypes.column.equals(column)) return benchmarkTypes;
            }
            throw new IllegalArgumentException("BenchmarkTypes not found.");
        }
    }


