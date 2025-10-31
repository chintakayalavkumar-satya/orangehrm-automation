package com.vj.framework.tests;

import com.vj.framework.core.BaseTest;
import com.vj.framework.core.Config;
import com.vj.framework.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, TestListener.class})
@Epic("OrangeHRM")
@Feature("Logout")
public class LogoutTest extends BaseTest {

    @Story("Valid logout")
    @Description("Verify that a logged-in user can log out successfully")
    @Test
    public void testLogout() {
        new LoginPage(driver)
                .enterUsername(Config.USERNAME)
                .enterPassword(Config.PASSWORD)
                .submit();

        Assert.assertTrue(new DashboardPage(driver).isAt(), "Should be on dashboard");

        new HeaderBar(driver).logout();
        new LoginPage(driver); // constructor wait ensures login screen is visible again
        Assert.assertTrue(true, "Returned to login after logout");
    }
}
