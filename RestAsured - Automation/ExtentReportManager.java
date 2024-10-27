package com.bookscart.utility;

import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager 
{
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException
	{
	
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"./ExtentReport/"+"MyReport.html");
		sparkReporter.loadXMLConfig(new File("extentconfig.xml"));
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "99BooksCart Store");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA Automation Testing");
		
	}
	
	public static void endReport()
	{
		extent.flush();
	}
	
}
