package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utility.Log;

public class Home_Page extends BaseClass{

	private static WebElement element = null;
	
	//By Objects
	public static By By_lnk_SignOn = By.linkText("SIGN-ON");
	public static By By_lnk_Register = By.linkText("Register");
	public static By By_txt_UserName = By.name("userName");
	public static By By_txt_Password = By.name("password");
	public static By By_btn_SignIn = By.name("login");
	
	//Constructor
	public Home_Page(WebDriver driver){
		super(driver);
	}    
	
	public static WebElement lnk_SignOn() throws Exception{

		try{ 
			element = driver.findElement(By_lnk_SignOn);
			Log.info("Sign On link is found on the Home Page");
		}catch (Exception e){
			Log.info("Sign On link is not found on the Home Page");
			throw(e);
		}
		return element;
	}

	public static WebElement lnk_Register() throws Exception{

		try{ 
			element = driver.findElement(By_lnk_Register);
			Log.info("Register link is found on the Home Page");
		}catch (Exception e){
			Log.info("Register link is not found on the Home Page");
			throw(e);
		}
		return element;
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
