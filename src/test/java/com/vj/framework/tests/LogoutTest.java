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

        new HeaderBar(driver).logout();          // perform logout

        // If we reached login page again, LoginPage constructor wait will pass
        new LoginPage(driver);
        Assert.assertTrue(true, "Returned to login after logout");
    }
}