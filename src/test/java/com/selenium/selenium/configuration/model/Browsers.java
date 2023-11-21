package com.selenium.selenium.configuration.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "browsers")
@Data
public class Browsers {
    private Map<String, BrowserProperties> all;
}
