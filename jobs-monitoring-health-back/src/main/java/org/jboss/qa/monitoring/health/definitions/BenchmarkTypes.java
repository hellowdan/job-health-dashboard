package org.jboss.qa.monitoring.health.definitions;

    public enum BenchmarkTypes {

        //DROOLS
        DMN("perf-dmn-benchmarks"),
        EVENT_PROCESSING("perf-event-processing-benchmarks"),
        EVENT_PROCESSING_MULTITHREADED("perf-event-processing-multithreaded-benchmarks"),
        OOPATH("perf-oopath-benchmarks"),
        OPERATORS("perf-operators-benchmarks"),
        SESSION("perf-session-benchmarks"),
        TURTLE_BUILDTIME("perf-turtle-buildtime-benchmarks"),
        TURTLE_RUNTIME("perf-turtle-runtime-benchmarks"),
        TURTLE_RUNTIME_MULTITHREADED("perf-turtle-runtime-multithreaded-benchmarks"),

        //DROOLS UPSTREAM
        UPSTREAM_DMN("upstream-perf-bre-dmn-benchmarks"),
        UPSTREAM_EVENT_PROCESSING("upstream-perf-bre-event-processing-benchmarks"),
        UPSTREAM_EVENT_PROCESSING_MULTITHREADED("upstream-perf-bre-event-processing-multithreaded-benchmarks"),
        UPSTREAM_OOPATH("upstream-perf-bre-oopath-benchmarks"),
        UPSTREAM_OPERATORS("upstream-perf-bre-operators-benchmarks"),
        UPSTREAM_SESSION("upstream-perf-bre-session-benchmarks"),
        UPSTREAM_BUILDTIME("upstream-perf-drools-buildtime-benchmarks"),
        UPSTREAM_TURTLE_BUILDTIME("upstream-perf-bre-turtle-buildtime-benchmarks"),
        UPSTREAM_RUNTIME("upstream-perf-bre-runtime-benchmarks"),
        UPSTREAM_TURTLE_RUNTIME("upstream-perf-bre-turtle-runtime-benchmarks"),
        UPSTREAM_TURTLE_RUNTIME_MULTITHREADED("upstream-perf-bre-turtle-runtime-multithreaded-benchmarks"),

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


