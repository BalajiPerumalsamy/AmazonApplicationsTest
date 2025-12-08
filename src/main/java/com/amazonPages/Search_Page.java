package com.amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;


public class Search_Page extends Base_Page
{
    public Search_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@type='text']")
    WebElement searchBox;

    @FindBy(xpath="//input[@type='submit']")
    WebElement search;

    @FindBy(xpath="//span[contains(text(),\"iQOO Z10x 5G\")]")
    WebElement clickProduct;

    @FindBy(xpath="//span[@id='productTitle']")
    WebElement productTitle;

    @FindBy(xpath="//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]/span[2]/span[2]")
    WebElement price;

    String name;
    String amount;

    public void product()
    {
        try
        {
            //clickButton(continueShopping);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(searchBox));
            writeText(properties.getProperty("productName"),searchBox);
            captureScreenshot("searchPage");
            clickButton(search);
            Thread.sleep(15000);
            captureScreenshot("ProductPage");
            //String parentWindow=driver.getWindowHandle();

            clickButton(clickProduct);
            Thread.sleep(15000);
            captureScreenshot("Product");
            Set<String> allWindows=driver.getWindowHandles();

            // Only one tab in set switch a tab use this method
        /*for(String childWindows:allWindows)
        {
            if(!childWindows.equals(parentWindow))
            {
                driver.switchTo().window(childWindows);
                break;
            }
        }*/

            // Multiple tab in a set switch specific tab use this method
            for(String tab:allWindows)
            {
                driver.switchTo().window(tab);
                if(driver.getTitle().contains("iQOO Z10x 5G"))
                {
                    break;
                }
            }
            name=productTitle.getText();
            amount=price.getText();
            System.out.println("Product Name = "+name);
            System.out.println("Product Price = "+amount);

        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
    public String actualProductName()
    {
        return name;
    }
    public String expectedProductName()
    {
        return "iQOO Z10x 5G (Ultramarine, 6GB RAM, 128GB Storage) | 6500 mAh Large Capacity Battery | Dimensity 7300 Processor | Military-Grade Durability";
    }
    public String actualPrice()
    {
        return amount;
    }
    public String expectedPrice()
    {
        return "14,999";
    }
}
