package com.crm.qa.testcases;

import org.testng.Assert;
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
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=0)
	public void userNameLabelTest()
	{
		testUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String homePageTitle=homePage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page tile not matched");
	}
	
	@Test (priority =2)
	public void contactsPageLink()
	{
		testUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		contactsPage=homePage.clickOnContactLink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
