package com.redbus.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public TestBase(){
	
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream
					("C:/Dell/Work/bookingautomate/src/main/java/com/redbus/config/Data.Properties");
			prop.load(fis);
		}
		catch(IOException e){
			e.getMessage();
		}	
		
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		String path= System.getProperty("user.dir");
		
		if(browserName.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","C:/Dell/Work/bookingautomate/src/test/resources/chromedriver.exe");	
			driver = new ChromeDriver(options);	
		}

		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", path+"\\src\\test\\resources\\test\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
