package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="newcontact";
	
	public ContactsPageTest()
	{
		super();	
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
	    initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
		
	}
	
	@Test(priority=1, enabled=false, groups= {"contacts"})
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsPageLabel(),"Contacts label is missing on Contacts Page");
	}
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
//}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> data=TestUtil.getDataFromExcelforNewContact(sheetName);
		return data.iterator();
	}
	
	@Test(dataProvider="getTestData", groups= {"contacts","smoke"})
	public void verifyCreateNewContactsTestUsingDDT(String title, String fName,String lName, String cName) throws InterruptedException
	{
		contactsPage=homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title,fName,lName,cName);
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
	driver.quit();
	}
}
