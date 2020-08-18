package org.jboss.qa.monitoring.health.definitions;

public enum CsvCepFileColumns {
    RULES_AND_EVENTS_NUMBER("Param: rulesAndEventsNumber");

    private String column;

    CsvCepFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}


