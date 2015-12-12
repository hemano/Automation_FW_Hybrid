package com.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utility.Log;

public class Register_Page extends BaseClass{

	private static WebElement element = null;
	
	public static By By_txt_FirstName = By.name("firstName");
	public static By By_txt_LastName = By.name("lastName");
	public static By By_txt_Phone = By.name("phone");
	public static By By_txt_Email = By.id("userName");
	public static By By_txt_Address1 = By.name("address1");
	public static By By_txt_Address2 = By.name("address2");
	public static By By_txt_City = By.name("city");
	public static By By_txt_State = By.name("state");
	public static By By_txt_PostalCode = By.name("postalCode");
	public static By By_sel_Country = By.name("country");
	public static By By_txt_UserName = By.name("email");
	public static By By_txt_Password = By.name("password");
	public static By By_txt_ConfirmPassword = By.name("confirmPassword");
	
	public static By By_btn_Submit = By.name("register");
	
	
	public Register_Page(WebDriver driver){
		super(driver);
	}    

	public static WebElement txt_FirstName() throws Exception{

		try{ 
			element = driver.findElement(By_txt_FirstName);
			Log.info("Register link is found on the Home Page");
		}catch (Exception e){
			Log.info("Register link is not found on the Home Page");
			throw(e);
		}
		return element;
	}

}
