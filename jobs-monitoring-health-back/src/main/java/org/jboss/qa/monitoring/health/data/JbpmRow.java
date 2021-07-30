package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvJbpmFileColumns;
import org.json.simple.JSONObject;

public class JbpmRow extends BenchmarksRow {

    private String mode;
    private String threads;
    private String runtimeManagerStrategy;

    public JbpmRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvJbpmFileColumns.MODE.getColumn()) != null) {
            this.mode = reportRow.get(CsvJbpmFileColumns.MODE.getColumn()).toString();
        }
        if (reportRow.get(CsvJbpmFileColumns.THREADS.getColumn()) != null) {
            this.threads = reportRow.get(CsvJbpmFileColumns.THREADS.getColumn()).toString();
        }
        if (reportRow.get(CsvJbpmFileColumns.RUNTIME_MANAGER_STRATEGY.getColumn()) != null) {
            this.runtimeManagerStrategy = reportRow.get(CsvJbpmFileColumns.RUNTIME_MANAGER_STRATEGY.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.mode.isEmpty()) {
            this.benchmark = this.benchmark + '_' + mode;
        }
        if (!this.threads.isEmpty()) {
            this.benchmark = this.benchmark + '_' + threads;
        }
        if (!this.runtimeManagerStrategy.isEmpty()) {
            this.benchmark = this.benchmark + '_' + runtimeManagerStrategy;
        }
    }
}
