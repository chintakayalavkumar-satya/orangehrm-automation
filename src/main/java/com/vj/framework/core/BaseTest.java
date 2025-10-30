package com.vj.framework.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"baseUrl"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("https://opensource-demo.orangehrmlive.com/") String baseUrl) {
        DriverFactory.initDriver("firefox");
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}