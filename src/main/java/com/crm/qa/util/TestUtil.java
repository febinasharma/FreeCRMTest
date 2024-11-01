package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
//import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIMEOUT = 20;
	//public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\febin\\eclipse-workspace\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Xls_Reader reader;

// Method to switch frame	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
	public static void takeScreenshot(WebDriver driver, String testName) throws IOException {
		String datetoString=new Date().toString().replace(":", "_").replace(" ", "_");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+testName+"_"+datetoString+".png"));
}
	

	public static ArrayList<Object[]> getDataFromExcelforNewContact()
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader("C:\\Users\\febin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\util\\TestData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("newcontact");rowNum++)
		{
			String title=reader.getCellData("newcontact", "Title", rowNum);
			String first_name=reader.getCellData("newcontact", "FirstName", rowNum);
			String last_name=reader.getCellData("newcontact", "LastName", rowNum);
			String company_name=reader.getCellData("newcontact", "CompanyName", rowNum);
			
			Object[] ob={title,first_name,last_name,company_name};
			myData.add(ob);
			
		}
		return myData;
		
	}
	
	

	
//	public static void takeScreenshot(WebDriver driver, String testName) throws IOException
//	{
//		Date date=new Date();
//		String datetoString=date.toString().replace(":", "_").replace(" ", "_");
//		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String currentDir= System.getProperty("user.dir");
//		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+testName+"_"+datetoString+".png"));
//	}
}
