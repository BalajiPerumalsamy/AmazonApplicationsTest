package com.amazonTests;

import com.amazonPages.Base_Page;
import com.amazonPages.Search_Page;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest extends Base_Page
{
    Base_Page basePage;
    Search_Page searchPage;
    public SearchPageTest()
    {
        super();
        PageFactory.initElements(driver,this);
    }
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
        Assert.assertEquals(searchPage.actualProductName(),searchPage.expectedProductName(),"Output mismatch");
        Assert.assertEquals(searchPage.actualPrice(), searchPage.expectedPrice(),"Price mismatch");
    }
}
