package org.jboss.qa.monitoring.health.definitions;

public enum ScheduleType {
    NIGHTLY("nightly"),
    WEEKLY("weekly");

    private String column;

    ScheduleType(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
