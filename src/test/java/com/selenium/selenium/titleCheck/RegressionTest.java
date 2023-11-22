package com.selenium.selenium.titleCheck;

import com.selenium.selenium.TestSeleniumApplication;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestSeleniumApplication.class)
public class RegressionTest extends DriverSetUp {

    @Test
    @Tag("regresja")
    public void testPageTitle() {
        driver.get(activeEnv.getWebUrl());
        System.out.println();
        pageTitleChecker.checkPageTitle(driver.getTitle(), activeEnv.getExpectedTitle());
    }
}
