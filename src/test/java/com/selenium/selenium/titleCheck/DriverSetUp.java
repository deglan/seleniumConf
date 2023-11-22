package com.selenium.selenium.titleCheck;

import com.selenium.selenium.configuration.SeleniumConfig;
import com.selenium.selenium.configuration.model.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Objects;

@Component
public class DriverSetUp {
    @Autowired
    private SeleniumConfig seleniumConfig;
    protected WebDriver driver;
    protected PageTitleChecker pageTitleChecker;
    protected String browserName;
    protected EnvironmentProperties activeEnv;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.safaridriver().setup();
    }

    @PostConstruct
    public void init() {
        this.browserName = seleniumConfig.getProperty("browser.name");
        this.activeEnv = findActiveEnvironment();
    }

    private EnvironmentProperties findActiveEnvironment() {
        String activeEnvKey = "environments." + seleniumConfig.getProperty("environment");

        EnvironmentProperties envProps = new EnvironmentProperties();
        envProps.setWebUrl(seleniumConfig.getProperty(activeEnvKey + ".webUrl"));
        envProps.setTitle(seleniumConfig.getProperty(activeEnvKey + ".title"));
        envProps.setExpectedTitle(seleniumConfig.getProperty(activeEnvKey + ".expectedTitle"));
        envProps.setLogin(seleniumConfig.getProperty(activeEnvKey + ".login"));
        envProps.setPassword(seleniumConfig.getProperty(activeEnvKey + ".password"));
        envProps.setExistingEmail(seleniumConfig.getProperty(activeEnvKey + ".existingEmail"));
        envProps.setExistingPassword(seleniumConfig.getProperty(activeEnvKey + ".existingPassword"));

        String timeoutStr = seleniumConfig.getProperty(activeEnvKey + ".timeout");
        if (timeoutStr != null && !timeoutStr.isEmpty()) {
            envProps.setTimeout(Integer.parseInt(timeoutStr));
        }

        return envProps;
    }

    @BeforeEach
    public void driverSetUp() {
        browserName = seleniumConfig.getProperty("browser.name");
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            case "safari" -> driver = new SafariDriver();
            case "ie" -> driver = new InternetExplorerDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        if (activeEnv != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(activeEnv.getTimeout()));
        }
        pageTitleChecker = new PageTitleChecker(driver);
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
