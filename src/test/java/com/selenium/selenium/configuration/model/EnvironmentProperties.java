package com.selenium.selenium.configuration.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;

@ConfigurationProperties(prefix = "environments")
@Configuration
@ContextConfiguration
@Data
public class EnvironmentProperties {

    private String envName;
    private String webUrl;
    private String title;
    private String expectedTitle;
    private String login;
    private String password;
    private String existingEmail;
    private String existingPassword;
    private int amount;
    private boolean active;
}
