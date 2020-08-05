package org.jboss.qa.monitoring.health.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"org.jboss.qa.monitoring.health"})
@EntityScan("org.jboss.qa.monitoring.health.*")
public class HealthDashboardBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthDashboardBackApplication.class, args);
    }
}
