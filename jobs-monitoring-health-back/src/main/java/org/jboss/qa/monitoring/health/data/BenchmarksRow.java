package org.jboss.qa.monitoring.health.data;

import org.jboss.qa.monitoring.health.definitions.CsvFileColumns;
import org.json.simple.JSONObject;

public abstract class BenchmarksRow {

    protected String job;
    protected String benchmark;
    protected String branch;
    protected String product;
    protected String score;
    protected String scoreError;

    public BenchmarksRow() {
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public String getScore() {
        return score;
    }

    public String getBranch() {
        return branch;
    }

    public String getProduct() {
        return product;
    }

    public String getScoreError() {
        return scoreError;
    }

    public void setScoreError(String scoreError) {
        this.scoreError = scoreError;
    }

    @Override
    public String toString() {
        return "BenchmarksRow{" +
                "job='" + job + '\'' +
                ", benchmark='" + benchmark + '\'' +
                ", branch='" + branch + '\'' +
                ", product='" + product + '\'' +
                ", score=" + score +
                ", scoreError=" + scoreError +
                '}';
    }

    public void parseReportRow(JSONObject reportRow, JobRow jobRow) {
        this.job = jobRow.getJob();
        this.branch = jobRow.getBranch();
        this.product = jobRow.getProduct();

        if (reportRow.get(CsvFileColumns.BENCHMARK.getColumn()) != null) {
            this.benchmark = ((String) reportRow.get(CsvFileColumns.BENCHMARK.getColumn()));
        }
        if (reportRow.get(CsvFileColumns.SCORE.getColumn()) != null) {
            this.score = reportRow.get(CsvFileColumns.SCORE.getColumn()).toString();
        }
        if (reportRow.get(CsvFileColumns.SCORE_ERROR.getColumn()) != null) {
            this.scoreError = reportRow.get(CsvFileColumns.SCORE_ERROR.getColumn()).toString();
        }
    }
}
