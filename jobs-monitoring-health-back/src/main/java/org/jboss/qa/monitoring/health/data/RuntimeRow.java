package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvRuntimeFileColumns;
import org.json.simple.JSONObject;

public class RuntimeRow extends BenchmarksRow {

    private String matchRatio = "";
    private boolean multithreaded;

    public RuntimeRow(boolean multithreaded) {
        this.multithreaded = multithreaded;
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvRuntimeFileColumns.MATCH_RATIO.getColumn()) != null) {
            this.matchRatio = reportRow.get(CsvRuntimeFileColumns.MATCH_RATIO.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.matchRatio.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.MATCH_RATIO.getColumn() + ":" + this.matchRatio;
        }
        if (this.multithreaded) {
            this.benchmark = this.benchmark + "_multithreaded";
        }
    }
}
