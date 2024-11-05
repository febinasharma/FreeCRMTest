package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.time.Month;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIMEOUT = 20;
	//public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\febin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\util\\TestData.xlsx";
	static Xls_Reader reader;
	static int count=0;

// Method to switch frame	
	public static void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
// Method to take screenshot	
	public static void takeScreenshot(WebDriver driver, String testName) throws IOException {
		String datetoString=new Date().toString().replace(":", "_").replace(" ", "_");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+testName+"_"+datetoString+".png"));
}
//Method to perform Menu Action
	public static void performMenuAction(WebElement menuName)
	{
		Actions action=new Actions(driver);
		action.moveToElement(menuName).build().perform();
	}
	
//Method to select a window
	public static void selectOpenWindow(String parentWindow,String windowTitle)
	{
		Set<String>openWindows=driver.getWindowHandles();
		Iterator<String> it=openWindows.iterator();
		while(it.hasNext())
		{
			String childWindow=it.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				
				driver.switchTo().window(childWindow);
			}
		}
	}
	
// Function to select a date from calendar
	public static void pickDateFromCalendar(WebElement monthAndYear, String dateToSelect, WebElement yearForward, WebElement monthForward, WebElement monthBackward,WebElement yearBackward ) throws InterruptedException
	{
		String actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
		int intYear=Integer.parseInt(monthAndYear.getText().split(" ")[1].trim());
		int intexpYear=Integer.parseInt(dateToSelect.split("/")[2].trim());
		int intexpMonth=Integer.parseInt(dateToSelect.split("/")[1].trim());
		String expDay= dateToSelect.split("/")[0].trim();
		String expMonthInString=monthNumberToFullName(intexpMonth);
	
		while(intexpYear>intYear)
		{
			monthForward.click();
			intYear=Integer.parseInt(monthAndYear.getText().split(" ")[1].trim());
			if(intYear==intexpYear)
			{
				System.out.println("Years are equal"+ intexpYear+":"+intYear);
				break;
			}
		}		
		actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
		while(expMonthInString!=actMonth)
		{
			if(actMonth.equalsIgnoreCase(expMonthInString))
			{
				break;
			}

			monthForward.click();
			actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
		}
//		intYear=Integer.parseInt(monthAndYear.getText().split(" ")[1].trim());


//		while(intexpYear<intYear)
//		{
//			yearBackward.click();
//			intYear=TestUtil.yearSelection(monthAndYear);
//			if(intYear==intexpYear)
//			{
//					break;
//			}
//		}
		
		driver.findElement(By.xpath("//td[text()='"+expDay+"']")).click();
	}
	
// Method to convert month from number to name (String equivalent)
	public static String monthNumberToFullName(int monthNumber) {
		  return Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.getDefault());
		}
	
// Method to access excel data 
	public static ArrayList<Object[]> getDataFromExcelforNewContact(String sheetName)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader(TESTDATA_SHEET_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("newcontact");rowNum++)
		{
			String title=reader.getCellData(sheetName, "Title", rowNum);
			String first_name=reader.getCellData(sheetName, "FirstName", rowNum);
			String last_name=reader.getCellData(sheetName, "LastName", rowNum);
			String company_name=reader.getCellData(sheetName, "CompanyName", rowNum);
			
			Object[] ob={title,first_name,last_name,company_name};
			myData.add(ob);
			
		}
		return myData;
		
	}
	
	public static ArrayList<Object[]> getDataFromExcelforNewDeals(String sheetName)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader(TESTDATA_SHEET_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("newdeals");rowNum++)
		{
			String company_name=reader.getCellData(sheetName, "Company", rowNum);
			String primary_contact=reader.getCellData(sheetName, "PrimaryContact", rowNum);
			String predicted_close_date=reader.getCellData(sheetName, "PredictedCloseDate", rowNum);
			
			Object[] ob={company_name,primary_contact,predicted_close_date,};
			myData.add(ob);
			
		}
		return myData;
		
	}

	
}
