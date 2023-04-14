package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declare Logout button
	@FindBy(id="logoutLink")
	private WebElement lgoutbtx;
	
	//Declare Task tab 
	@FindBy(id="container_tasks")
	private WebElement tasktab;

	//Initialisation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Click Logout button
	public void setLogout()
	{
		lgoutbtx.click();
	}
	

	//Click Task buton
	public void setTasktab()
	{
		tasktab.click();
	}

	
}
