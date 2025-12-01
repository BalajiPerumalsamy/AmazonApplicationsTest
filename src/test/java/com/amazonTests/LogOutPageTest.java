package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.LogOut_Page;
import com.amazonPages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogOutPageTest
{
    Base_Page basePage;
    Login_Page loginPage;
    LogOut_Page logOutPage;

    @BeforeTest
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        loginPage=new Login_Page();
        loginPage.ApplicationLogin();
    }
    @Test
    public void verifyLogoutFunction()
    {
        logOutPage=new LogOut_Page();
        logOutPage.accountSignOut();
    }
    @AfterTest
    public void tearDown()
    {
        Assert.assertEquals(logOutPage.actualOutput(),logOutPage.expectedOutput(),"Logout Actual and Expected Output is mismatch");
        System.out.println("Account successful LogOut");
    }
}
