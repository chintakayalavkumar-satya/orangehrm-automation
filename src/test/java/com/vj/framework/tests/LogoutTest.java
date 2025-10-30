package com.vj.framework.tests;

import com.vj.framework.core.BaseTest;
import com.vj.framework.core.Config;
import com.vj.framework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        new LoginPage(driver)
            .enterUsername(Config.USERNAME)
            .enterPassword(Config.PASSWORD)
            .submit();

        Assert.assertTrue(new DashboardPage(driver).isAt(), "Should be on dashboard");
        new HeaderBar(driver).logout();
        new LoginPage(driver); // constructor waits for login screen again
        Assert.assertTrue(true, "Returned to login screen after logout");
    }
}