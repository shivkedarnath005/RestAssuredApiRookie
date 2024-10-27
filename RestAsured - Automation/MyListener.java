package com.bookscart.utility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.bookscart.base.BaseClass;


public class MyListener extends ExtentReportManager implements ITestListener 
{

	
	public void onTestStart(ITestResult result) 
	{
		//test = extent.createTest(result.getTestClass().getName());//create new entry in the report
		test = extent.createTest(result.getMethod().getMethodName());
	}
 
	public void onTestSuccess(ITestResult result) 
	{
	
		//test = extent.createTest(result.getTestClass().getName());//create new entry in the report
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS,"Test Case PASSED is:"+ result.getName());//update test status pass/fail/skip
		
	}

	//RESULT OBJECT CONTAINS ALL THE DETAILS OF THE TEST METHOD NAME ETC
	public void onTestFailure(ITestResult result)
	{
		//test = extent.createTest(result.getTestClass().getName());
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,"Test Case FAILED is:"+ result.getName());
		test.log(Status.INFO, "Test Case FAILED cause is:"+result.getThrowable());
		
		try 
		{
			new BaseClass();
			String imgPath = BaseClass.captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

	}
	
	public void onTestSkipped(ITestResult result) 
	{
		//test = extent.createTest(result.getTestClass().getName());
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Case SKIPPED is:"+ result.getName());
		test.log(Status.INFO, "Test Case SKIPPED cause is:"+result.getThrowable());
	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
	}
}
