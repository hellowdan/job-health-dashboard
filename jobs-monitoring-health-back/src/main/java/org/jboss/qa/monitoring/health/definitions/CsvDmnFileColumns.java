package org.jboss.qa.monitoring.health.definitions;

public enum CsvDmnFileColumns {
    EXPRESSION("Param: expression"),
    NUMBER_OF_DECISION_TABLE_RULES("Param: numberOfDecisionTableRules"),
    NUMBER_OF_DECISIONS("Param: numberOfDecisions"),
    NUMBER_OF_DECISIONS_WITH_BKM("Param: numberOfDecisionsWithBKM"),
    NUMBER_OF_DECISIONS_WITH_CONTEXT("Param: numberOfDecisionsWithContext"),
    NUMBER_OF_ELEMENTS("Param: numberOfElements"),
    PARAM("Param: param"),
    RESOURCE_NAME("Param: resourceName"),
    SPARSENESS("Param: sparseness");

    private String column;

    CsvDmnFileColumns(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}


