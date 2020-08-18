package org.jboss.qa.monitoring.health.definitions;

public enum CsvBuildtimeFileColumns {
    NUMBER_OF_RULES("Param: numberOfRules"),
    NR_OF_RULES("Param: nrOfRules"),
    USE_CANONICAL_MODEL("Param: useCanonicalModel"),
    RULES_PROVIDER_ID("Param: rulesProviderId");

    private String column;

    CsvBuildtimeFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}