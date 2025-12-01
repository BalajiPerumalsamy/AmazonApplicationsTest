package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.SignIn_Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInPageTest
{
    Base_Page basePage;
    SignIn_Page signInPage;
    @BeforeTest
    public void setup()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
    }
    @Test
    public void verifySignInFunction()
    {
        signInPage=new SignIn_Page();
        signInPage.applicationSignIn();
    }
}
