package org.jboss.qa.monitoring.health.definitions;

    public enum BenchmarkTypes {
        DMN("blessed-perf-dmn-benchmarks"),
        EVENT_PROCESSING("blessed-perf-event-processing-benchmarks"),
        EVENT_PROCESSING_MULTITHREADED("blessed-perf-event-processing-multithreaded-benchmarks"),
        OOPATH("blessed-perf-oopath-benchmarks"),
        OPERATORS("blessed-perf-operators-benchmarks"),
        SESSION("blessed-perf-session-benchmarks"),
        BUILDTIME("blessed-perf-turtle-buildtime-benchmarks"),
        RUNTIME("blessed-perf-turtle-runtime-benchmarks"),
        RUNTIME_MULTITHREADED("blessed-perf-turtle-runtime-multithreaded-benchmarks");

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


