package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest
{
    Base_Page basePage;
    Login_Page loginPage;

    @BeforeTest
    public void setup()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
    }

    @Test
    public void Login()
    {
        loginPage=new Login_Page();
        loginPage.ApplicationLogin();
        Assert.assertEquals(loginPage.actualOutput(),loginPage.expectedOutput(),"Login Actual and Expected Output is mismatch");
    }

    @AfterTest
    public void tearDown()
    {
        basePage.quitApplication();
    }
}
