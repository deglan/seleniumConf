package com.selenium.selenium.titleCheck;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
@Slf4j
public class PageTitleChecker {

    private WebDriver driver;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void checkPageTitle(String actualTitle, String expectedTitle) {
        Assertions.assertEquals(expectedTitle, actualTitle, "Message.INCORRECT_TITLE.getMessage()");
        log.info("Sprawdzanie tytułu strony: Oczekiwany={}, Aktualny={}", expectedTitle, actualTitle);
    }
}
