package org.jboss.qa.monitoring.health.definitions;

public enum CsvRuntimeFileColumns {
    MATCH_RATIO("Param: matchRatio");

    private String column;

    CsvRuntimeFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}


