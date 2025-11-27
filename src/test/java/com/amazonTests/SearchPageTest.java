package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.Search_Page;
import org.junit.Assert;
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
        Assert.assertEquals("Output Mismatch",searchPage.expectedProductName(),searchPage.actualProductName());
        Assert.assertEquals("Price mismatch",searchPage.expectedPrice(),searchPage.actualPrice());
    }
}
