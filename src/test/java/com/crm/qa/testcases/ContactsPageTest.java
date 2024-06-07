package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.excelreader.ExcelXLSReader;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ExcelXLSReader excelReader;
	String sheetName="contacts";
	
	public ContactsPageTest()
	{
		super();	
		
	}
	
	@BeforeMethod
	public void setup()
	{
	    initialization();
		//contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
	//	excelReader=new ExcelXLSReader(prop.getProperty("excelFilePath"));
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		
		
		
	}
	
//	@Test(priority=1)
//	public void verifyContactsPageLabelTest()
//	{
//		Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"Contacts label is missing on Contacts Page");
//	}
//	
//	@Test(priority=0)
//	public void verifySelectingSingleContactsTest()
//	{
//		contactsPage.selectContactsByName("Bawish");
//	}
//	@Test
//	public void verifySelectingMultipleContactsTest()
//	{
//		contactsPage.selectContactsByName("Krishna");
//		contactsPage.selectContactsByName("David");
//	}
	// **** For Excel data***********
//	@DataProvider
//	public Object[][] getTestData()
//	{
//		Object data[][]=excelReader.getSheetData(sheetName);
//		return data;
//	}
//	
//	@Test(priority=0, dataProvider="getTestData")
//	public void verifyCreateNewContactTest(String title, String firstName,String lastName, String compName)
//	{
//		homePage.clickOnNewContactsLink();
//		contactsPage.createNewContact(title,firstName,lastName,compName);
//	}
	//***********************
	@Test(priority=0)
	public void verifyCreateNewContactTest()
	{
		contactsPage=homePage.clickOnContactLink();
		contactsPage.clickOnNewContactsLink();
		contactsPage.createNewContact("Ms.","Meera","Varma","Lindt");
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
