package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory
	@FindBy (xpath="//td[contains(text(),'User: Gagan Khanna')]")
	WebElement userNameLabel;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	

	

	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUsernameLabel()
	{
		
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}

	
	
	

}
