package com.vj.framework.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"baseUrl"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("https://opensource-demo.orangehrmlive.com/") String baseUrl) {
        // Initialize WebDriver
        DriverFactory.initDriver("firefox");

        // Assign the driver
        driver = DriverFactory.getDriver();

        // Configure browser defaults
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to URL
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Quit the driver safely
        DriverFactory.quitDriver();
    }
}
