package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvDmnFileColumns;
import org.json.simple.JSONObject;

public class DmnRow extends BenchmarksRow {

    private String expression = "";
    private String numberOfDecisionTableRules = "";
    private String numberOfDecisions = "";
    private String numberOfDecisionsWithBKM = "";
    private String numberOfDecisionsWithContext = "";
    private String numberOfElements = "";
    private String param = "";
    private String resourceName = "";
    private String sparseness = "";

    public DmnRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvDmnFileColumns.EXPRESSION.getColumn()) != null) {
            this.expression = reportRow.get(CsvDmnFileColumns.EXPRESSION.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISION_TABLE_RULES.getColumn()) != null) {
            this.numberOfDecisionTableRules = reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISION_TABLE_RULES.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS.getColumn()) != null) {
            this.numberOfDecisions = reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_BKM.getColumn()) != null) {
            this.numberOfDecisionsWithBKM = reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_BKM.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_CONTEXT.getColumn()) != null) {
            this.numberOfDecisionsWithContext = reportRow.get(CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_CONTEXT.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.NUMBER_OF_ELEMENTS.getColumn()) != null) {
            this.numberOfElements = reportRow.get(CsvDmnFileColumns.NUMBER_OF_ELEMENTS.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.PARAM.getColumn()) != null) {
            this.param = reportRow.get(CsvDmnFileColumns.PARAM.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.RESOURCE_NAME.getColumn()) != null) {
            this.resourceName = reportRow.get(CsvDmnFileColumns.RESOURCE_NAME.getColumn()).toString();
        }
        if (reportRow.get(CsvDmnFileColumns.SPARSENESS.getColumn()) != null) {
            this.sparseness = reportRow.get(CsvDmnFileColumns.SPARSENESS.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.expression.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.EXPRESSION.getColumn() + ":" + this.expression;
        }
        if (!this.numberOfDecisionTableRules.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.NUMBER_OF_DECISION_TABLE_RULES.getColumn() + ":" + this.numberOfDecisionTableRules;
        }
        if (!this.numberOfDecisions.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.NUMBER_OF_DECISIONS.getColumn() + ":" + this.numberOfDecisions;
        }
        if (!this.numberOfDecisionsWithBKM.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_BKM.getColumn() + ":" + this.numberOfDecisionsWithBKM;
        }
        if (!this.numberOfDecisionsWithContext.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.NUMBER_OF_DECISIONS_WITH_CONTEXT.getColumn() + ":" + this.numberOfDecisionsWithContext;
        }
        if (!this.numberOfElements.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.NUMBER_OF_ELEMENTS.getColumn() + ":" + this.numberOfElements;
        }
        if (!this.param.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.PARAM.getColumn() + ":" + this.param;
        }
        if (!this.resourceName.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.RESOURCE_NAME.getColumn() + ":" + this.resourceName;
        }
        if (!this.sparseness.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvDmnFileColumns.SPARSENESS.getColumn() + ":" + this.sparseness;
        }
    }
}
