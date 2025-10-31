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
@Feature("Login")
public class LoginTest extends BaseTest {

    @Story("Valid login")
    @Description("Verify that a user can log in with valid credentials")
    @Test
    public void testValidLogin() {
        new LoginPage(driver)
                .enterUsername(Config.USERNAME)
                .enterPassword(Config.PASSWORD)
                .submit();

        Assert.assertTrue(new DashboardPage(driver).isAt(), "Should land on dashboard");
    }
}
