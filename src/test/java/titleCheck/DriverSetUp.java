package titleCheck;

import com.selenium.selenium.configuration.SeleniumConfig;
import com.selenium.selenium.configuration.model.BrowserProperties;
import com.selenium.selenium.configuration.model.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverSetUp {
    @Autowired
    private SeleniumConfig seleniumConfig;
    protected WebDriver driver;
    protected PageTitleChecker pageTitleChecker;
    protected BrowserProperties activeBrowser;
    protected EnvironmentProperties activeEnv;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.iedriver().setup();
    }

    @PostConstruct
    public void init() {
        activeBrowser = findActiveBrowser();
        activeEnv = findActiveEnvironment();
    }

    private BrowserProperties findActiveBrowser() {
        return seleniumConfig.getBrowsers().getAll().values().stream()
                .filter(BrowserProperties::isActive)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No active browser configured"));
    }

    private EnvironmentProperties findActiveEnvironment() {
        return seleniumConfig.getEnvironments().getAll().values().stream()
                .filter(EnvironmentProperties::isActive)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No active environment configured"));
    }

    @BeforeEach
    public void driverSetUp() {
        driver = BrowserStrategy.from(activeBrowser.getName()).getDriver();
        pageTitleChecker = new PageTitleChecker(driver);
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
