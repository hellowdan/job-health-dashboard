package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvCepFileColumns;
import org.json.simple.JSONObject;

public class CepRow extends BenchmarksRow {

    private String rulesAndEventsNumber = "";
    private boolean multithreaded;

    public CepRow(boolean multithreaded) {
        this.multithreaded = multithreaded;
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvCepFileColumns.RULES_AND_EVENTS_NUMBER.getColumn()) != null) {
            this.rulesAndEventsNumber = reportRow.get(CsvCepFileColumns.RULES_AND_EVENTS_NUMBER.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.rulesAndEventsNumber.isEmpty()) {
            this.benchmark = this.benchmark + '_' +CsvCepFileColumns.RULES_AND_EVENTS_NUMBER.getColumn() + ":" + this.rulesAndEventsNumber;
        }
        if (this.multithreaded) {
            this.benchmark = this.benchmark + "_multithreaded";
        }
    }
}
