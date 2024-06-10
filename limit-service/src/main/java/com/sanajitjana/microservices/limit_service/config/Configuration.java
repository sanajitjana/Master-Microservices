package com.sanajitjana.microservices.limit_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
@Data
public class Configuration {
    private int minimum;
    private int maximum;
}
