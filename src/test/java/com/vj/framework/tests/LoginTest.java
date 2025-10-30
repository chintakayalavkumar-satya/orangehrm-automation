package com.vj.framework.tests;

import com.vj.framework.core.BaseTest;
import com.vj.framework.core.Config;
import com.vj.framework.pages.DashboardPage;
import com.vj.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername(Config.USERNAME)
             .enterPassword(Config.PASSWORD)
             .submit();

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isAt(), "Dashboard should be visible after login");
    }
}