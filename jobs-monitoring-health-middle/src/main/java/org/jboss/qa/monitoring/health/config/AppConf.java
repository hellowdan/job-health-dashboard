package org.jboss.qa.monitoring.health.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "https://jobs-monitoring-health-baqe-jobs-dashboards.6923.rh-us-east-1.openshiftapps.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}