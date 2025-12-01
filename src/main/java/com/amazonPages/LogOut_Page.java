package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut_Page extends Base_Page
{
    public LogOut_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@role='button']/span[text()='All']")
    WebElement clickAllButton;

    @FindBy(xpath="//a[text()='Sign Out']")
    WebElement signOutButton;

    @FindBy(xpath="//*[@id=\"claim-collection-container\"]/h1")
    WebElement verifyTitle;

    public void accountSignOut()
    {
        clickButton(clickAllButton);
        clickButton(signOutButton);
    }

    public String actualOutput()
    {
        return verifyTitle.getText();
    }

    public String expectedOutput()
    {
        return "Sign in or create account";
    }
}
