package com.selenium.selenium.configuration;

import com.selenium.selenium.configuration.model.Browsers;
import com.selenium.selenium.configuration.model.Environments;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "selenium")
@Data
public class SeleniumConfig {

    private Browsers browsers;
    private Environments environments;
}
