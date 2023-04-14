package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class CreateTask extends BaseClass {

	@Test
	public void testCreateTask() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Click on TaskTab from Home Page-Calling Setters method from Homepage pom class
		HomePage h=new HomePage(driver);
		Thread.sleep(6000);
		h.setTasktab();
		
		//creating Object ref for tasklist Pom Page
		TaskList t=new TaskList(driver);
		
		//click on Addnew Button
		t.getAddnew().click();
		//click on newTask button
		t.getNewtask().click();
		
		//Create object ref for FileLib class
		FileLib f=new FileLib();
		
		//Read and store customer name from Excel  to a variable
		String custoname=f.getExcelData("createcustomer", 1, 3);
	//	Thread.sleep(7000);
		//Add some wait until that particular webelement is visibile
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(t.getSelectcustomerTask()));
		//Click on selectCustomerTask
		t.getSelectcustomerTask().click();
		//Enter our customer name to selec t the name from list
		t.getSelectcustomerTaskinput().sendKeys(custoname);
		//Click our customer name from list
		t.getCustomernamefromdropdowntask().click();
		
		//Read and store project name from excel and store
		String projname=f.getExcelData("createproject", 1, 3);
		
		//Click on selectproject
		t.getSelectprojecttask().click();
		//Enter projectname to select project textfield
		t.getSelectprojectTaskinput().sendKeys(projname);
		//click our project name from list
		t.getProjectnamefromdropdown().click();
		
		//read taskname from excel and store to a variable
		String taskname = f.getExcelData("createtask", 1, 3);
		
		//Enter taskname
		t.getEntertaskname().sendKeys(taskname);
		//click on createtask button
		t.getCreatetaskButton().click();
		
		//Add explicit wait until the taskname displayed onthe page
		WebDriverWait wait2=new WebDriverWait(driver, 10);	
		wait2.until(ExpectedConditions.textToBePresentInElement(t.getTasknametext(), taskname));
		
		//Fetch the text from there are store to a variable
		String acttaskname=t.getTasknametext().getText();
		
		//Create obj ref for softassert 
		SoftAssert s=new SoftAssert();
		//compare actual text and expected
		s.assertEquals(taskname, acttaskname);
		s.assertAll();
		Thread.sleep(3000);
	}

}
