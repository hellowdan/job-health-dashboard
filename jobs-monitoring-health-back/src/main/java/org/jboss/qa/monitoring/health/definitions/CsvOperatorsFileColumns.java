package org.jboss.qa.monitoring.health.definitions;

public enum CsvOperatorsFileColumns {
    RULES_AND_FACTS_NUMBER("Param: rulesAndFactsNumber");

    private String column;

    CsvOperatorsFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}


