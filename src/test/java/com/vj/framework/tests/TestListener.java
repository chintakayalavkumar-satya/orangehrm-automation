package com.vj.framework.tests;

import com.vj.framework.core.DriverFactory;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Path outDir() {
        Path p = Path.of("test-output", "artifacts");
        try { Files.createDirectories(p); } catch (IOException ignored) {}
        return p;
    }
    @Override public void onTestFailure(ITestResult r) {
        WebDriver d = DriverFactory.getDriver();
        if (d == null) return;
        String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String base = r.getMethod().getMethodName() + "_" + stamp;
        try { Files.write(outDir().resolve(base + ".png"),
                ((TakesScreenshot)d).getScreenshotAs(OutputType.BYTES)); } catch (Exception ignored) {}
        try { Files.writeString(outDir().resolve(base + ".html"), d.getPageSource()); } catch (Exception ignored) {}
        try { Files.writeString(outDir().resolve(base + "_url.txt"), d.getCurrentUrl()); } catch (Exception ignored) {}
    }
}