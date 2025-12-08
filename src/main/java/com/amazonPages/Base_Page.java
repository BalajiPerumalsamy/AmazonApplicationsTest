package com.amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;

public class Base_Page
{
    public static WebDriver driver;
    Properties properties;
    public static WebDriverWait wait;

    @FindBy(xpath="//button[@type='submit']")
    WebElement continueShopping;

    public Base_Page()
    {
        String filePath="C:\\Users\\ELCOT\\IdeaProjects\\AmazonApplication\\src\\main\\java\\com\\amazonPages\\Config.properties";
        properties=new Properties();
        try
        {
            FileInputStream file=new FileInputStream(filePath);
            properties.load(file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public void navigateToApplication()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        driver.get(properties.getProperty("url"));
    }
    public void writeText(String text,WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void clickButton(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void quitApplication()
    {
        driver.quit();
    }

    public void captureScreenshot(String fileName)
    {
        try
        {
            TakesScreenshot screenshot=(TakesScreenshot) driver;
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("./Screenshots/" + fileName + ".png");
            FileHandler.copy(src,file);
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}