package com.vj.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By breadcrumb = By.cssSelector("h6.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private final By sideMenu   = By.cssSelector("aside.oxd-sidepanel");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isAt() {
        try {
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(breadcrumb),
                ExpectedConditions.visibilityOfElementLocated(sideMenu)
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}