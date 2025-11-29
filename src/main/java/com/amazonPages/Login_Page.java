package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Base_Page
{
    public Login_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='nav-line-1-container']")
    WebElement clickSignInButton;

    @FindBy(xpath="//input[@id='ap_email_login']")
    WebElement enterEmailId;

    @FindBy(xpath="//input[@type='submit']")
    WebElement clickContinueButton;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='signInSubmit']")
    WebElement clickSignIn;

    @FindBy(xpath="//span[text()='Hello, BALAJI']")
    WebElement name;

    public void ApplicationLogin()
    {
        clickButton(continueShopping);
        clickButton(clickSignInButton);
        writeText(properties.getProperty("emailId"),enterEmailId);
        clickButton(clickContinueButton);
        writeText(properties.getProperty("password"),password);
        clickButton(clickSignIn);
    }

    public String actualOutput()
    {
        return name.getText();
    }

    public String expectedOutput()
    {
        return "Hello, BALAJI";
    }
}
