package com.crm.qa.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//PageFactory
	
	@FindBy (xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy (xpath="//select[@name='title']")
	WebElement titleSelect;
	
	@FindBy (xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy (xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy (name="client_lookup")
	WebElement company;
	
	@FindBy (xpath="//td[@colspan='2']/input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	//Initializing the Page Objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String contactName)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]/../..//input[@type='checkbox']")).click();
		
	}
	
		

	public void createNewContact(String title, String ftName, String ltName, String compName)
	{
		Select select=new Select(titleSelect);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(compName);
		saveBtn.click();
	}

}
