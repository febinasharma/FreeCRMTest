package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

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
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(.,'New Deal')]")
	WebElement newDealMenuOption;
	

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
	
	public ContactsPage clickOnNewContactLink() throws InterruptedException
	{
		driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		return new ContactsPage();
	}
	public ContactsPage clickOnContactLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnNewDealsLink()
	{
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		TestUtil.performMenuAction(dealsLink);
		newDealMenuOption.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}

	
	
	

}
