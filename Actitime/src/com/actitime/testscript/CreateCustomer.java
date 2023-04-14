package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
import com.actitime.pom.TaskList;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateCustomer extends BaseClass
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		//create object ref for Homepage pom class
		HomePage h=new HomePage(driver);
		//call settersTasktab-click tasktab
		Thread.sleep(6000);
		h.setTasktab();
		
		//create obj ref for Tasklist
		TaskList t=new TaskList(driver);
		
		//Create object ref for Filelib
		FileLib f=new FileLib();
		
		//read customer name from the excel
		String custname=f.getExcelData("createcustomer", 1, 3);
		//read customer description from excel 
		String customdescription=f.getExcelData("createcustomer", 1, 4);
		
		//click addnew button
		t.getAddnew().click();
		//click newcustomer button
		t.getNewcustomer().click();
		//enter the customer name
		t.getEntercustomername().sendKeys(custname);
		//Enter customer description
		t.getEnterCustomerDescription().sendKeys(customdescription);
		//click on Select customer
		t.getSelectCustomer().click();
		//enter ourcompany in textfield
		t.getSelectcustomerinput().sendKeys("our company");
		//select ourcompany from list
		//t.getOurCompany().click();//-------------------------------
		//click on creater customer button
		t.getCreateCustomer().click();
		
		//take text from the Resultpage(Page coming after creating customer)
		WebElement ele=t.getCustomername();
		//add explicit wait to wait until new customer name displayed /result page displayed
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, custname));
		
		//Creating object ref for the softassert
		SoftAssert s=new SoftAssert();
		String actCustomname = t.getCustomername().getText();
		Reporter.log("here is"+actCustomname,true);
		//compare actual and expected
		s.assertEquals(actCustomname,custname);
		s.assertAll();
		
		//Explicit wait to wait until logout button displayed
		WebDriverWait wait1=new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
		
	}

}
