package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utility.Log;

public class LogIn_Page extends BaseClass{

	private static WebElement element = null;
	
	//By Objects
	public static By By_txt_UserName = By.name("userName");
	public static By By_txt_Password = By.name("password");
	public static By By_btn_SignIn = By.name("login");
	
	//Constructor
	public LogIn_Page(WebDriver driver){
		super(driver);
	}    
	
	public static WebElement txt_UserName() throws Exception{

		try{ 
			element = driver.findElement(By_txt_UserName);
			Log.info("UserName text box is found on the Home Page");
		}catch (Exception e){
			Log.info("UserName text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}


	public static WebElement txt_Password() throws Exception{

		try{ 
			element = driver.findElement(By_txt_Password);
			Log.info("Password text box is found on the Home Page");
		}catch (Exception e){
			Log.info("Password text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement btn_SignIn() throws Exception{

		try{ 
			element = driver.findElement(By_btn_SignIn);
			Log.info("Sign In button is found on the Home Page");
		}catch (Exception e){
			Log.info("Sign In button is not found on the Home Page");
			throw(e);
		}
		return element;
	}

}
