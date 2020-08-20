package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvOopathFileColumns;
import org.json.simple.JSONObject;

public class OopathRow extends BenchmarksRow {

    private String accumulateFunction = "";
    private String numberOfFacts = "";
    private String numberOfParentFacts = "";
    private String numberOfRules = "";

    public OopathRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvOopathFileColumns.ACCUMULATE_FUNCTION.getColumn()) != null) {
            this.accumulateFunction = reportRow.get(CsvOopathFileColumns.ACCUMULATE_FUNCTION.getColumn()).toString();
        }
        if (reportRow.get(CsvOopathFileColumns.NUMBER_OF_FACTS.getColumn()) != null) {
            this.numberOfFacts = reportRow.get(CsvOopathFileColumns.NUMBER_OF_FACTS.getColumn()).toString();
        }
        if (reportRow.get(CsvOopathFileColumns.NUMBER_OF_PARENT_FACTS.getColumn()) != null) {
            this.numberOfParentFacts = reportRow.get(CsvOopathFileColumns.NUMBER_OF_PARENT_FACTS.getColumn()).toString();
        }
        if (reportRow.get(CsvOopathFileColumns.NUMBER_OF_RULES.getColumn()) != null) {
            this.numberOfRules = (String) reportRow.get(CsvOopathFileColumns.NUMBER_OF_RULES.getColumn());
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.accumulateFunction.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvOopathFileColumns.ACCUMULATE_FUNCTION.getColumn() + ":" + this.accumulateFunction;
        }
        if (!this.numberOfFacts.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvOopathFileColumns.NUMBER_OF_FACTS.getColumn() + ":" + this.numberOfFacts;
        }
        if (!this.numberOfParentFacts.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvOopathFileColumns.NUMBER_OF_PARENT_FACTS.getColumn() + ":" + this.numberOfParentFacts;
        }
        if (!this.numberOfRules.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvOopathFileColumns.NUMBER_OF_RULES.getColumn() + ":" + this.numberOfRules;
        }
    }
}
