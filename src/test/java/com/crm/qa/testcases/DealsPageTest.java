package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	String sheetName="newdeals";
	DealsPageTest()
	{
		super();
	}
	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> data=TestUtil.getDataFromExcelforNewDeals(sheetName);
		return data.iterator();
	}
	
	
	@Test(dataProvider="getTestData",groups= {"deals", "dt01"})
	public void verifyNewDealsFormUsingExcel(String cName, String pContact,String pCloseDate) throws InterruptedException
	{
		dealsPage=homePage.clickOnNewDealsLink();
		dealsPage.createNewDeals(cName, pContact, pCloseDate);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}
