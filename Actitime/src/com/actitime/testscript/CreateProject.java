package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskList;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateProject extends BaseClass{

	@Test
	public void testCreateProject() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//click task button from Home page
		HomePage h=new HomePage(driver);
		Thread.sleep(6000);
		h.setTasktab();
		
		//click add new Button from Tasklist page
		TaskList t=new TaskList(driver);
		t.getAddnew().click();
		
		//click new project button
		t.getNewproject().click();
		
		//Create obj ref for Filelib class
		FileLib f=new FileLib();
		//Read proejct name from the Excel
		String projname=f.getExcelData("createproject", 1, 3);
		//Enter project name in textfield
		t.getEnterprojectname().sendKeys(projname);
		
		//Read customer name from Excel
		String custname=f.getExcelData("createcustomer", 1, 3);
		//click on the selectCustomer dropdown
		t.getSelectcustomerproject().click();
		//Enter customer name
		t.getSelectcustomerprojectinput().sendKeys(custname);
		//click on that particular customer name
		t.getCustomernamefromdropdown().click();
		
		//read project description from the excel
		String projdes=f.getExcelData("createproject", 1, 5);
		System.out.println(projdes);
		//Enter project Description
		Thread.sleep(4000);
		t.getProjectdescription().sendKeys(projdes);
		
		//click on create proejct button
		t.getCreateprojectButton().click();
		
		//Add explicit wait to wait until the new project name displayed
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getPrjectnametext(), projname));
		
		//create obj ref for softassert
		SoftAssert s=new SoftAssert();
		//fetch the project name from resultpage
		String actprojname=t.getPrjectnametext().getText();
		Reporter.log("here is"+actprojname,true);
		//compare actual and expected
		s.assertEquals(actprojname, projname);
		s.assertAll();
		
		
		
		
		
	}
}
