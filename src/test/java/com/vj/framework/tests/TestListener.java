package com.vj.framework.tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.nio.charset.StandardCharsets;

public class TestListener implements ITestListener, ISuiteListener {

    private WebDriver driverFrom(Object testInstance) {
        try {
            var field = testInstance.getClass().getSuperclass().getDeclaredField("driver"); // in BaseTest
            field.setAccessible(true);
            return (WebDriver) field.get(testInstance);
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override public void onTestFailure(ITestResult result) {
        Object test = result.getInstance();
        WebDriver driver = driverFrom(test);

        // Screenshot
        if (driver instanceof TakesScreenshot ts) {
            byte[] png = ts.getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment("Failure screenshot", "image/png", "png", png);
        }

        // Page source (optional, small)
        if (driver != null) {
            byte[] html = driver.getPageSource().getBytes(StandardCharsets.UTF_8);
            Allure.getLifecycle().addAttachment("Page source", "text/html", "html", html);
        }

        // Error message as text
        Throwable t = result.getThrowable();
        if (t != null) {
            Allure.addAttachment("Exception", "text/plain", t.toString());
        }
    }
}
