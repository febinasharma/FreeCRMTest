package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.Xls_Reader;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverListener eventListener;
	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\febin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resource\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
		}

	//Event Listener code
		
		eventListener=new WebEventListener();
		driver = new EventFiringDecorator<WebDriver>(eventListener).decorate(driver);
			
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		
		
	}
}
