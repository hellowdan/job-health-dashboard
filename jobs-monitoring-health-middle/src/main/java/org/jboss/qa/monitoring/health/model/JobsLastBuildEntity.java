package org.jboss.qa.monitoring.health.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "jobs_last_build")
public class JobsLastBuildEntity {

    @Id
    @Column(name = "jobs_id")
    private Long jobs_id;

    @Column(name = "job")
    private String job;
    @Column(name = "product")
    private String product;
    @Column(name = "branch")
    private String branch;
    @Column(name = "folder")
    private String folder;
    @Column(name = "subfolder")
    private String subfolder;
    @Column(name = "active")
    private int active;
    @Column(name = "last_build_number")
    private Double last_build_number;

    public JobsLastBuildEntity() {
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getSubfolder() {
        return subfolder;
    }

    public void setSubfolder(String subfolder) {
        this.subfolder = subfolder;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Long getJobs_id() {
        return jobs_id;
    }

    public void setJobs_id(Long jobs_id) {
        this.jobs_id = jobs_id;
    }

    public Double getLast_build_number() {
        return last_build_number;
    }

    public void setLast_build_number(Double last_build_number) {
        this.last_build_number = last_build_number;
    }

    @Override
    public String toString() {
        return "JobsLastBuildEntity{" +
                "job='" + job + '\'' +
                ", product='" + product + '\'' +
                ", branch='" + branch + '\'' +
                ", folder='" + folder + '\'' +
                ", subfolder='" + subfolder + '\'' +
                ", active=" + active +
                ", jobs_id=" + jobs_id +
                ", last_build_number=" + last_build_number +
                '}';
    }
}
