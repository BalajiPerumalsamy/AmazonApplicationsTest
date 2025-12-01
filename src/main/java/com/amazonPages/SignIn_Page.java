package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignIn_Page extends Base_Page
{
    public SignIn_Page()
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

    @FindBy(xpath="//*[@id=\"intention-submit-button\"]/span/input")
    WebElement proceedButton;

    @FindBy(xpath="//select[@name='countryCode']")
    WebElement countryCode;

    @FindBy(xpath="//input[@id='ap_phone_number']")
    WebElement mobileNumber;

    @FindBy(xpath="//input[@type='text']")
    WebElement name;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='continue']")
    WebElement verifyMobileNumber;

    //Same Mobile Number that time use this
    @FindBy(xpath="//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(xpath="//input[@type='submit']")
    WebElement createAmazonAccount;

    //Same Mobile number that time we use return Home signIn page
    @FindBy(xpath="//*[@id=\"authportal-main-section\"]/div[2]/div/div/div[2]/div[2]/a")
    WebElement anotherEmailOrMobile;

    public void applicationSignIn()
    {
        try
        {
            clickButton(continueShopping);
            clickButton(clickSignInButton);
            writeText(properties.getProperty("newEmailId"),enterEmailId);
            clickButton(clickContinueButton);
            clickButton(proceedButton);
            Select country=new Select(countryCode);
            country.selectByValue(properties.getProperty("countryCode"));
            writeText(properties.getProperty("mobileNumber"),mobileNumber);
            writeText(properties.getProperty("name"),name);
            writeText(properties.getProperty("newPassword"),password);
            clickButton(verifyMobileNumber);
            Thread.sleep(20000);
            clickButton(createAmazonAccount);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
