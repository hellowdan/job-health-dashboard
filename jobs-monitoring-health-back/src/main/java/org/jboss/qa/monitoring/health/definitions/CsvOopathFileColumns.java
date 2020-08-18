package org.jboss.qa.monitoring.health.definitions;

public enum CsvOopathFileColumns {
    ACCUMULATE_FUNCTION("Param: accumulateFunction"),
    NUMBER_OF_FACTS("Param: numberOfFacts"),
    NUMBER_OF_PARENT_FACTS("Param: numberOfParentFacts"),
    NUMBER_OF_RULES("Param: numberOfRules");

    private String column;

    CsvOopathFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}


