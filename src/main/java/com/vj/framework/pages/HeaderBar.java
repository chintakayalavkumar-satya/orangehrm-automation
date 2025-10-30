package com.vj.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HeaderBar {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By userMenu = By.cssSelector(".oxd-userdropdown-tab,.oxd-userdropdown-name");
    private final By logout = By.xpath("//a[normalize-space()='Logout']");

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }
}