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
        // 1) Force geckodriver location (offline)
        System.setProperty("webdriver.gecko.driver", "C:\\\\drivers\\\\geckodriver.exe");

        // 2) Force Firefox binary path (avoid MSIX/custom-install issues)
        String firefoxBinary = "C:\\\\Program Files\\\\Mozilla Firefox\\\\firefox.exe";
        // If your Firefox is elsewhere, change the path above EXACTLY.

        org.openqa.selenium.firefox.FirefoxOptions opts = new org.openqa.selenium.firefox.FirefoxOptions();
        opts.setBinary(firefoxBinary);
        // Stable window size (Firefox ignores --start-maximized sometimes)
        opts.addArguments("--width=1920", "--height=1080");

        // 3) Capture geckodriver logs to a file so we can inspect if it still fails
        System.setProperty("webdriver.firefox.logfile", "C:\\\\drivers\\\\geckodriver.log");

        DRIVER.set(new org.openqa.selenium.firefox.FirefoxDriver(opts));
    }

    public static WebDriver getDriver() { return DRIVER.get(); }

    public static void quitDriver() {
        WebDriver d = DRIVER.get();
        if (d != null) { d.quit(); DRIVER.remove(); }
    }
}