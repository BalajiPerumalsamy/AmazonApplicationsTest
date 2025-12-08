package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.Search_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest
{
    Base_Page basePage;
    Search_Page searchPage;
    @BeforeMethod
    public void setUp()
    {
        basePage=new Base_Page();
        basePage.navigateToApplication();
        basePage.captureScreenshot("HomePage");
    }
    @Test
    public void searchProduct()
    {
        searchPage=new Search_Page();
        searchPage.product();
    }
    @AfterMethod
    public void verifyProduct()
    {
        try
        {
            Assert.assertEquals(searchPage.actualProductName(),searchPage.expectedProductName(),"Output Mismatch");
            Assert.assertEquals(searchPage.actualPrice(),searchPage.expectedPrice(),"Price mismatch");
            Thread.sleep(15000);
            basePage.quitApplication();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
