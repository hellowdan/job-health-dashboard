package org.jboss.qa.monitoring.health.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daily_benchmarks")
public class BenchmarksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;

    @Column(name="job")
    private String job;

    @Column(name="id")
    private String product;

    @Column(name="branch")
    private String branch;

    @Column(name="name")
    private String name;

    @Column(name="score")
    private String score;

    @Column(name="day")
    private int day;

    @Column(name="month")
    private int month;

    @Column(name="year")
    private int year;

    @Column(name="date_of_record")
    private LocalDateTime dateOfRecord;

    @Column(name="date_of_recordts")
    private Timestamp dateOfRecordTS;

    public BenchmarksEntity() {
    }

    public Long getId() {
        return id;
    }

    public BenchmarksEntity(String job, String name, String product, String branch, String score) {
        LocalDate localDate = LocalDate.now();
        this.job = job;
        this.name = name;
        this.product = product;
        this.branch = branch;
        this.score = score;
        this.day = localDate.getDayOfMonth();
        this.month = localDate.getMonthValue();
        this.year = localDate.getYear();
        this.dateOfRecord = LocalDateTime.now();
        this.dateOfRecordTS = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "BenchmarksEntity{" +
                "job='" + job + '\'' +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", branch='" + branch + '\'' +
                ", score=" + score +
                '}';
    }
}
