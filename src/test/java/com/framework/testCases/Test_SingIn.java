package com.framework.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.appModules.SignIn_Action;
import com.framework.pageObjects.BaseClass;
import com.framework.utility.Constant;
import com.framework.utility.ExcelUtils;
import com.framework.utility.Log;
import com.framework.utility.Utils;

public class Test_SingIn {

	public WebDriver driver;	 
	private String sTestCaseName; 
	private int iTestCaseRow;
	
	//TestNg test cases pattern
	
	@BeforeMethod
	public void beforeTest() throws Exception{

	    // Configuring Log4j logs
	  	DOMConfigurator.configure("log4j.xml");
 
	  	// Getting the Test Case name
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
 
	  	sTestCaseName = this.toString();
 
	  	// refine the test case name
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
 
	  	// Logging
		Log.startTestCase(sTestCaseName);
 
		// Setting up the Test Data Excel file using Constants variables 
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"SignIn");
 
		// Fetching the Test Case row number from the Test Data Sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
 
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
 
		// Initializing the Base Class for Selenium driver 
		new BaseClass(driver);  
		
	}
	
	  // Main Test Case
	 
	  @Test
	 
	  public void main() throws Exception {
	 	 
		  try{
	 
			// Here we are calling the SignIN Action and passing argument (iTestCaseRow)	 
			SignIn_Action.Execute(iTestCaseRow);
	 	 	 
//			Verification_Action.Execute();
			
			if(Constant.ReservationPage_Title.equals(driver.getTitle().trim())){
				Reporter.log("Verification passed for ReservationPage_Title");
			}else{
				Reporter.log("Verification failed for ReservationPage_Title");
				Reporter.log("Verification failed for ReservationPage_Title");
				BaseClass.bResult=false;
			}
	 
	 
			// This is to check that if any of your verification during the execution is failed	 
			if(BaseClass.bResult==true){
	 
				// If the value of boolean variable is True, then your test is complete pass and do this
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_LoginResult);
	 
			}else{
	 
				// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
				// This is to throw exception in case of fail test, this exception will be caught by catch block below
	 
				throw new Exception("Test Case Failed because of Verification");
	 
			}
	 
		  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	 
		  }catch (Exception e){
	 
			  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
	 
			  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_LoginResult);
	 
			  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
	 
			  Utils.takeScreenshot(driver, sTestCaseName);
	 
			  // This will print the error log message
	 
			  Log.error(e.getMessage());
	 
			  // Again throwing the exception to fail the test completely in the TestNG results
			  
			  throw (e);
	 
		  }
	 
	  }
	 
	  // Its time to close the finish the test case		
	 
	  @AfterMethod
	  public void afterMethod() {
	 
		    // Printing beautiful logs to end the test case
	 
		    Log.endTestCase(sTestCaseName);
	 
		    // Closing the opened driver
	 
		    driver.close();
	 
	  		}
}
