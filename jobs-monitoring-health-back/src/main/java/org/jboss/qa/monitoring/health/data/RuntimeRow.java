package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvRuntimeFileColumns;
import org.json.simple.JSONObject;

public class RuntimeRow extends BenchmarksRow {

    private String joinCount = "";
    private String matchRatio = "";
    private String nestedAccumulates = "";
    private String objectsPerSegment = "";
    private String perSegmentUpdate = "";
    private String segmentCount = "";


    private boolean multithreaded;

    public RuntimeRow(boolean multithreaded) {
        this.multithreaded = multithreaded;
    }

    @Override
    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        super.parseReportRow(reportRow, jobRow);

        if (reportRow.get(CsvRuntimeFileColumns.JOIN_COUNT.getColumn()) != null) {
            this.joinCount = reportRow.get(CsvRuntimeFileColumns.JOIN_COUNT.getColumn()).toString();
        }

        if (reportRow.get(CsvRuntimeFileColumns.MATCH_RATIO.getColumn()) != null) {
            this.matchRatio = reportRow.get(CsvRuntimeFileColumns.MATCH_RATIO.getColumn()).toString();
        }

        if (reportRow.get(CsvRuntimeFileColumns.NESTED_ACCUMULATES.getColumn()) != null) {
            this.nestedAccumulates = reportRow.get(CsvRuntimeFileColumns.NESTED_ACCUMULATES.getColumn()).toString();
        }

        if (reportRow.get(CsvRuntimeFileColumns.OBJECTS_PER_SEGMENT.getColumn()) != null) {
            this.objectsPerSegment = reportRow.get(CsvRuntimeFileColumns.OBJECTS_PER_SEGMENT.getColumn()).toString();
        }

        if (reportRow.get(CsvRuntimeFileColumns.PER_SEGMENT_UPDATE.getColumn()) != null) {
            this.perSegmentUpdate = reportRow.get(CsvRuntimeFileColumns.PER_SEGMENT_UPDATE.getColumn()).toString();
        }

        if (reportRow.get(CsvRuntimeFileColumns.SEGMENT_COUNT.getColumn()) != null) {
            this.segmentCount = reportRow.get(CsvRuntimeFileColumns.SEGMENT_COUNT.getColumn()).toString();
        }

        updateBenchmarkTitle();
    }

    public void updateBenchmarkTitle() {
        if (!this.joinCount.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.JOIN_COUNT.getColumn() + ":" + this.joinCount;
        }
        if (!this.matchRatio.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.MATCH_RATIO.getColumn() + ":" + this.matchRatio;
        }
        if (!this.nestedAccumulates.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.NESTED_ACCUMULATES.getColumn() + ":" + this.nestedAccumulates;
        }
        if (!this.objectsPerSegment.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.OBJECTS_PER_SEGMENT.getColumn() + ":" + this.objectsPerSegment;
        }
        if (!this.perSegmentUpdate.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.PER_SEGMENT_UPDATE.getColumn() + ":" + this.perSegmentUpdate;
        }
        if (!this.segmentCount.isEmpty()) {
            this.benchmark = this.benchmark + '_' + CsvRuntimeFileColumns.SEGMENT_COUNT.getColumn() + ":" + this.segmentCount;
        }
        if (this.multithreaded) {
            this.benchmark = this.benchmark + "_multithreaded";
        }
    }
}
