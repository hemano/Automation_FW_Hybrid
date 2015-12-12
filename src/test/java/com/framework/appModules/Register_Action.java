package com.framework.appModules;

import org.testng.Reporter;

import com.framework.pageObjects.Home_Page;
import com.framework.utility.Log;

public class Register_Action {

   	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    public static void Execute(int iTestCaseRow) throws Exception{

    	// Clicking on the My Account link on the Home Page
    	Home_Page.lnk_Register().click();
    	Log.info("Click action is perfromed on Register link" );

        Reporter.log("Register Action is successfully perfomred");
    }
}
