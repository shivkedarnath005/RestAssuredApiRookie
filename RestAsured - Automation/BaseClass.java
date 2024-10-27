package com.bookscart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bookscart.utility.ExtentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static final Logger log=LogManager.getLogger(BaseClass.class.getName());
	
	public static WebDriver getDriver() 
	{
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	@BeforeSuite(groups={"Smoke","Sanity","Regression"})
	public void loadConfig() throws FileNotFoundException, IOException
	{
		ExtentReportManager.setExtent();
		
		File file=new File("log4j2.xml");
		LoggerContext context=(LoggerContext) LogManager.getContext(false);
		context.setConfigLocation(file.toURI());
		
		prop=new Properties();
		System.out.println("Super Constructor is Invoked");
		FileInputStream ip;
		ip=new FileInputStream(System.getProperty("user.dir")+
				"./src/main/resources/Config.properties");
		prop.load(ip);
		
	}
	

	public static void setupBrowser(String browserName)
	{
		//String browserName=prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
				{
			       WebDriverManager.firefoxdriver().setup();
			       driver.set(new FirefoxDriver());
				}
		      else if(browserName.equalsIgnoreCase("IE"))
		           {
		    	      WebDriverManager.iedriver().setup();
		    	      driver.set(new InternetExplorerDriver());
		           }
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().get(prop.getProperty("Url"));
		
	}
	
	public static String captureScreenshot(String fileName) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File sourceFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); 
		String targetFilePath=System.getProperty("user.dir")+"./ScreenShots/" + fileName + " " + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentReportManager.endReport();
	}
	
	
}
