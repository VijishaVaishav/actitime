package com.actitime.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.FileLib;

public class LoginPage {
	
	//Declare username textfield
	@FindBy (id="username")
	private WebElement untbx;
	
	//Declare password textfield
	@FindBy(name="pwd")
	private WebElement pwdtbx;
	
	//Declare Loginbutton 
	@FindBy(id="loginButton")
	private WebElement lgbtn;
	
	//Initialisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//login function-Enter username,passowrd and click login button
	public void setLogin() throws IOException
	{
		//Reading data from Excel file through getPropertyData of FileLib class
		FileLib f=new FileLib();
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		untbx.sendKeys(un);
		pwdtbx.sendKeys(pw);
		lgbtn.click();
	}

}
