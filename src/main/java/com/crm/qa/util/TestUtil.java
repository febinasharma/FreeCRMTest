package com.crm.qa.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtil extends TestBase{

	public static final long PAGE_LOAD_TIMEOUT = 20;
	//public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\febin\\eclipse-workspace\\CRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xls";
	

// Method to switch frame	
	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
}
