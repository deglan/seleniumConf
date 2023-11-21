package com.selenium.selenium.configuration.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ConfigurationProperties(prefix = "environments")
@Configuration
@ContextConfiguration
@Data
public class Environments {

    private Map<String, EnvironmentProperties> all;
}
