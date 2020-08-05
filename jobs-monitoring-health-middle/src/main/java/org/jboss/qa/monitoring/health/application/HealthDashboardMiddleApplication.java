package org.jboss.qa.monitoring.health.application;

import org.jboss.qa.monitoring.health.controller.BenchmarksController;
import org.jboss.qa.monitoring.health.controller.JobsController;
import org.jboss.qa.monitoring.health.controller.UpdateStatusController;
import org.jboss.qa.monitoring.health.dao.BenchmarksRepository;
import org.jboss.qa.monitoring.health.dao.StatusRepository;
import org.jboss.qa.monitoring.health.dao.JobsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.jboss.qa.monitoring.health"})
@EnableJpaRepositories(basePackageClasses= {JobsRepository.class, StatusRepository.class, BenchmarksRepository.class})
@ComponentScan(basePackageClasses = {JobsController.class, UpdateStatusController.class, BenchmarksController.class})
@EntityScan("org.jboss.qa.monitoring.health.*")
public class HealthDashboardMiddleApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthDashboardMiddleApplication.class, args);
    }
}
