package org.jboss.qa.monitoring.health.data;

public class BenchmarksRow {

    private String job;
    private String benchmark;
    private String branch;
    private String product;
    private String score;

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

    public String getUniqueID() {
        return "benchmark" + this.job +
                "|name=" + this.benchmark;
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

    @Override
    public String toString() {
        return "BenchmarksRow{" +
                "benchmark='" + job + '\'' +
                ", name='" + benchmark + '\'' +
                ", score=" + score +
                '}';
    }
}
