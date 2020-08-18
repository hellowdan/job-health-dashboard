package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvBuildtimeFileColumns;
import org.jboss.qa.monitoring.health.definitions.CsvFileColumns;
import org.json.simple.JSONObject;

public class BuildtimeRow extends BenchmarksRow {

    private String numberOfRules = "";
    private String nrOfRules = "";
    private String useCanonicalModel = "";
    private String rulesProviderId = "";

    public BuildtimeRow() {
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvBuildtimeFileColumns.NUMBER_OF_RULES.getColumn()) != null) {
            this.numberOfRules = reportRow.get(CsvBuildtimeFileColumns.NUMBER_OF_RULES.getColumn()).toString();
        }
        if (reportRow.get(CsvBuildtimeFileColumns.NR_OF_RULES.getColumn()) != null) {
            this.nrOfRules = reportRow.get(CsvBuildtimeFileColumns.NR_OF_RULES.getColumn()).toString();
        }
        if (reportRow.get(CsvBuildtimeFileColumns.USE_CANONICAL_MODEL.getColumn()) != null) {
            this.useCanonicalModel = reportRow.get(CsvBuildtimeFileColumns.USE_CANONICAL_MODEL.getColumn()).toString();
        }
        if (reportRow.get(CsvBuildtimeFileColumns.RULES_PROVIDER_ID.getColumn()) != null) {
            this.rulesProviderId = (String) reportRow.get(CsvBuildtimeFileColumns.RULES_PROVIDER_ID.getColumn());
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        this.benchmark = this.benchmark + '_' +
                CsvBuildtimeFileColumns.NUMBER_OF_RULES.getColumn()+":"+this.numberOfRules + '_' +
                CsvBuildtimeFileColumns.NR_OF_RULES.getColumn()+":"+this.nrOfRules + '_' +
                CsvBuildtimeFileColumns.USE_CANONICAL_MODEL.getColumn()+":"+this.useCanonicalModel + '_' +
                CsvBuildtimeFileColumns.RULES_PROVIDER_ID.getColumn()+":"+this.rulesProviderId;
    }
}
