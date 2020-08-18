package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvOperatorsFileColumns;
import org.json.simple.JSONObject;

public class OperatorsRow extends BenchmarksRow {

    private String rulesAndFactsNumber = "";

    public OperatorsRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvOperatorsFileColumns.RULES_AND_FACTS_NUMBER.getColumn()) != null) {
            this.rulesAndFactsNumber = reportRow.get(CsvOperatorsFileColumns.RULES_AND_FACTS_NUMBER.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        this.benchmark = this.benchmark + '_' +
                CsvOperatorsFileColumns.RULES_AND_FACTS_NUMBER.getColumn()+":"+this.rulesAndFactsNumber;
    }
}
