package com.vj.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(username),
                ExpectedConditions.visibilityOfElementLocated(loginBtn)
        ));
    }

    public LoginPage enterUsername(String user) {
        WebElement u = wait.until(ExpectedConditions.elementToBeClickable(username));
        u.clear(); u.sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        WebElement p = wait.until(ExpectedConditions.elementToBeClickable(password));
        p.clear(); p.sendKeys(pass);
        return this;
    }

    public void submit() {
        try { driver.findElement(loginBtn).submit(); }
        catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        }
    }
}