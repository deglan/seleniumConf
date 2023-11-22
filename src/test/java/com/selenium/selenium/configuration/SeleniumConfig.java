package com.selenium.selenium.configuration;

import com.selenium.selenium.configuration.model.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)
public class SeleniumConfig {

    private final Environment env;

    @Autowired
    public SeleniumConfig(Environment env) {
        this.env = env;
    }

    public String getProperty(String key) {
        return env.getProperty(key);
    }
}
