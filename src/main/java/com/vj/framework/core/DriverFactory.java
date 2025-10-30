package com.vj.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void initDriver(String browser) {
        // Force firefox to keep it offline-stable for first green run
        startFirefoxOffline();
    }

    private static void startFirefoxOffline() {
        org.openqa.selenium.firefox.FirefoxOptions opts = new org.openqa.selenium.firefox.FirefoxOptions();
        opts.addArguments("--width=1920", "--height=1080");

        if (System.getenv("CI") == null) {
            // Local dev: use your local geckodriver + installed Firefox binary
            System.setProperty("webdriver.gecko.driver", "C:\\\\drivers\\\\geckodriver.exe");
            opts.setBinary("C:\\\\Program Files\\\\Mozilla Firefox\\\\firefox.exe");
        } else {
            // CI (Ubuntu): let Selenium Manager resolve geckodriver & use headless
            opts.addArguments("-headless");
        }
        DRIVER.set(new org.openqa.selenium.firefox.FirefoxDriver(opts));
    }

    public static WebDriver getDriver() { return DRIVER.get(); }

    public static void quitDriver() {
        WebDriver d = DRIVER.get();
        if (d != null) { d.quit(); DRIVER.remove(); }
    }
}