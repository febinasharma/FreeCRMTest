package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	ContactsPage contactsPage;
	TasksPage tasksPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		initialization();
		//testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
	}
	
	@Test(priority=1, enabled=false, groups= {"home"})
	public void userNameLabelTest()
	{
		
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}
	@Test(priority=0, enabled=true, groups= {"home","smoke"})
	public void homePageTitleTest()
	{
		String homePageTitle=homePage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page tile not matched");
	}
	
	@Test (priority =2,enabled=false, groups= {"home"})
	public void contactsPageLink() throws InterruptedException
	{
		//testUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		contactsPage=homePage.clickOnContactLink();
	}
	
	@Test(priority =2,enabled=false, groups= {"home"})
	public void verifyNewDealslink()
	{
		dealsPage=homePage.clickOnNewDealsLink();
	}
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}
	
	
}
