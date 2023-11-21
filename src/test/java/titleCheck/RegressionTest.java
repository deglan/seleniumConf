package titleCheck;

import com.selenium.selenium.TestSeleniumApplication;
import com.selenium.selenium.configuration.SeleniumConfig;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestSeleniumApplication.class)
public class RegressionTest extends DriverSetUp {

    @Tag("regresja")
    @Test
    public void testPageTitle() {
        driver.get(activeEnv.getWebUrl());
        pageTitleChecker.checkPageTitle(driver.getTitle(), activeEnv.getExpectedTitle());
    }
}
