package org.jboss.qa.monitoring.health.definitions;

public enum CsvJbpmFileColumns {
    MODE("Mode"),
    THREADS("Threads"),
    RUNTIME_MANAGER_STRATEGY("Param: runtimeManagerStrategy");

    private String column;

    CsvJbpmFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
