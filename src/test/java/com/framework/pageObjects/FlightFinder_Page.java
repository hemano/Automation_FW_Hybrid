package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utility.Log;

public class FlightFinder_Page extends BaseClass{

	private static WebElement element = null;
	
	//By Objects
	public static By By_lnk_SignOff = By.linkText("SIGN-OFF");
	
	//Constructor
	public FlightFinder_Page(WebDriver driver){
		super(driver);
	}    
	
	public static WebElement lnk_SignOff() throws Exception{

		try{ 
			element = driver.findElement(By_lnk_SignOff);
			Log.info("Sign Off Link is found on the Flight Finder Page");
		}catch (Exception e){
			Log.info("Sign Off Link is not found on the Flight Finder Page");
			throw(e);
		}
		return element;
	}
	
	public static String getPageTitle(){
		return driver.getTitle();
	}
	
	
	
	
}
