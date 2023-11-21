package com.selenium.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.selenium.selenium"})
public class TestSeleniumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSeleniumApplication.class, args);
    }

}
