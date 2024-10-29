package com.crm.qa.util;

/*************************************** PURPOSE **********************************

- This class implements the WebDriverEventListener, which is included under events.
The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
which would be displayed/logged as the application under test is being run.

Do not call any of these methods, instead these methods will be invoked automatically
as an when the action done (click, findBy etc). 

*/
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;



public class WebEventListener implements WebDriverListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

//	public void afterClickOn(WebElement element, WebDriver driver) 
	public  void afterClick(WebElement element){
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	
//	@Override
//	public void onError(Object target, Method method, Object[] args, InvocationTargetException error) {
//		System.out.println("Exception occured onError: " + error);
//		try {
//			String testName= method.getName();
//			TestUtil.takeScreenshotAtEndOfTest(driver,testName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public void onException(Throwable error, WebDriver driver) {
//		System.out.println("Exception occured: " + error);
//		try {
//			TestUtil.takeScreenshotAtEndOfTest();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void afterClose(WebDriver driver) {
	System.out.println("After closing the browser");
	}

	@Override
	public void afterSubmit(WebElement element) {
		System.out.println("After submitting: "+element.toString());
	}

	@Override
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("After submitting: "+element.toString()+" "+keysToSend);
		
	}

	@Override
	public void afterMaximize(Window window) {
		System.out.println("After Maximizing window "+window.toString());
	}

	public void afterQuit(WebDriver driver)
	{
		System.out.println("Test Execution Completed");
	}
	@Override
	public void afterGet(WebDriver driver, String url) {
		System.out.println("After navigating to URL: "+url);
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Before finding element: " + locator.toString());
	}

	@Override
	public void afterFindElement(WebDriver driver,By by,WebElement result){
		System.out.println("After finding element: " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}	
