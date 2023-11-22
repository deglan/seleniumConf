package com.selenium.selenium.configuration.model;

import lombok.Data;

@Data
public class EnvironmentProperties {

    private String webUrl;
    private String title;
    private String expectedTitle;
    private String login;
    private String password;
    private String existingEmail;
    private String existingPassword;
    private int timeout;
    private boolean active;
}