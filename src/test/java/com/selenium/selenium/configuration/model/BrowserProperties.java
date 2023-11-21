package com.selenium.selenium.configuration.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

@ConfigurationProperties(prefix = "browsers")
@ContextConfiguration
@Data
public class BrowserProperties {

    private String name;
    private String driver;
    private boolean active;
}
