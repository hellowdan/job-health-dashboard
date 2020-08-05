package org.jboss.qa.monitoring.health.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"org.jboss.qa.monitoring.health"})
@EnableJpaRepositories(basePackages= {"org.jboss.qa.monitoring.health.*"})
@EntityScan("org.jboss.qa.monitoring.health.*")
@EnableAutoConfiguration
public class HealthDashboardMiddleApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthDashboardMiddleApplication.class, args);
    }
}
