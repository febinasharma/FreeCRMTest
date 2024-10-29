package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(groups={"login"},priority=1)
	
	public void loginPagetitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	@Test(groups={"lg02"},priority=0)
	public void crmLogoImageTest() throws IOException
	{
		boolean flag= loginPage.validateCRMImg();
		Assert.assertTrue(flag);
	
	}
	@Test(groups={"smoke","login"},priority=2)
	public void loginTest() throws IOException
	{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}
