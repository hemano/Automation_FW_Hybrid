package com.framework.appModules;

import org.testng.Reporter;

import com.framework.pageObjects.FlightFinder_Page;
import com.framework.pageObjects.Home_Page;
import com.framework.pageObjects.LogIn_Page;
import com.framework.utility.Constant;
import com.framework.utility.ExcelUtils;
import com.framework.utility.Log;
import com.framework.utility.Utils;

public class SignIn_Action {

   	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    public static void Execute(int iTestCaseRow) throws Exception{

    	// Clicking on the My Account link on the Home Page

    	Home_Page.lnk_SignOn().click();

    	Log.info("Click action is perfromed on My Account link" );

    	// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
    	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet

    	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LoginUserName);

    	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
    	// This is call Page Object Model (POM)

        LogIn_Page.txt_UserName().sendKeys(sUserName);

        // Printing the logs for what we have just performed
        Log.info(sUserName+" is entered in UserName text box" );

        String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LoginPassword);
        
        LogIn_Page.txt_Password().sendKeys(sPassword);
        Log.info(sPassword+" is entered in Password text box" );

        LogIn_Page.btn_SignIn().click();
        Log.info("Click action is performed on Submit button");

        // Now it will wait 10 secs separately before jumping out to next step

        Utils.waitForElement(FlightFinder_Page.lnk_SignOff());

        // This will populate the logs in the TestNG HTML reports
        Reporter.log("SignIn Action is successfully perfomred");

    }
}
