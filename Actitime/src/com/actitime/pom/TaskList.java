package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskList {

	//Declare Add new Button
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addnew;
	
	//Declare new customer button
	@FindBy(xpath="//div[contains(text(),'New Customer')]")
	private WebElement newcustomer;
	
/*Declare the Elements present in AddnewCustomer Popup*/
	
	//Declare Enter customer name textfield
	@FindBy(xpath ="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement entercustomername;
	
	//Declare EnterCustomer Description textfield
	@FindBy(xpath ="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescription;
	
	//Declare the Select customer Dropdown element
	@FindBy(xpath ="(//div[contains(text(),'Select Customer')])[1]")
	private WebElement selectCustomer;
	
	//Declare the textfield of selectcuctomer(after clicking the select cuctomer dropdown)
	@FindBy(xpath="//div[text()='- Select Customer -']/../..//div[@class='inputPlaceholder']/input")
	private WebElement selectcustomerinput;
	
	//Declare Ourcompany which showing in the list
	@FindBy(xpath="//div[@class='itemRow cpItemRow ']/span[contains(text(),'company')]")
	private WebElement ourCompany;
	
	//Declare CreateCustomer button
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomer;
	
	//Declare the Customer name showing in the page after the customer creation
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement customername;
	
/*Declaring The elements present in add new project popup*/
	
	//Declare new customer button
	@FindBy(xpath = "//div[contains(text(),'New Project')]")
	private WebElement newproject;
	
	//declaring  enter project name textfield
	@FindBy(xpath="(//input[@placeholder='Enter Project Name'])[2]")
	private WebElement enterprojectname;
	
	// Declare selectcustomer dropdown element
	@FindBy(xpath="//div[contains(text(),'Please Select Customer to Add Project for')]")
	private WebElement selectcustomerproject;
	
	//select customer textfield(afterclick the dropdown)
	@FindBy(xpath="//div[contains(text(),'Please Select Customer to Add Project for')]/../../div[2]//div[@class='inputPlaceholder']/input")
	private WebElement selectcustomerprojectinput;
	
	//customer name from the dropdown
	@FindBy(xpath = "//div[@class='itemRow cpItemRow ']/span")
	private WebElement customernamefromdropdown;
	
	//projectdescription textfield
	@FindBy(xpath="//textarea[@placeholder='Add Project Description']")
	private WebElement projectdescription;
	
	//Declare Create project button
	@FindBy(xpath = "//div[text()='Create Project']")
	private WebElement createprojectButton;
	
	//Text(project title) after creating a new project(for comparison)
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement prjectnametext;
	
/*Declaring Elements present in Addnew Task Popup*/	
	
	//Declaring newtask button
	@FindBy(xpath = "//div[text()='+ New Tasks']")
	private WebElement newtask;
	
	//Declare select customer dropdwn element
	@FindBy(xpath="//tr[@class='selectCustomerRow']//div[@class='selectedItem']")
	private WebElement selectcustomerTask;
	
	//Declare selectcustomer dropwdown textfield(after click)
	@FindBy(xpath="//tr[@class='selectCustomerRow']//div[@class='inputPlaceholder']/input")
	private WebElement selectcustomerTaskinput;
	
	//Declare particular customer name from the dropdown
	@FindBy(xpath="//div[@class='itemRow cpItemRow ']/span")
	private WebElement customernamefromdropdowntask;
	
	//Declare the select project dropdown element
	@FindBy(xpath="//tr[@class='selectProjectRow projectSelectorRow']//div[@class='selectedItem']")
	private WebElement selectprojecttask;
	
	//Declare the select project dropdown textfield
	@FindBy(xpath="//tr[@class='selectProjectRow projectSelectorRow']//div[@class='inputPlaceholder']/input")
	private WebElement selectprojectTaskinput;
	
	//select particular proj name from dropdown
	@FindBy(xpath="(//div[@class='itemRow cpItemRow ']//span)[2]")
	private WebElement projectnamefromdropdown;
	
	//Declare taskname textfield
	@FindBy(xpath="//tr[1]/td[@class='nameCell first']//input[@placeholder='Enter task name']")
	private WebElement entertaskname;
	
	//Declare create taskname button
	@FindBy(xpath = "//div[text()='Create Tasks']")
	private WebElement createtaskButton;
	
	//Declare the TASK name showing in the page after the customer creation
	@FindBy(xpath = "//tr[@class='taskRow noLastTrackingDate']//div[@class='title']")
	private WebElement tasknametext;
	
	//Initialisation
	public TaskList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//getter method fro Addnew Button
	public WebElement getAddnew() {
		return addnew;
	}

	//getter method for newcustomer Button
	public WebElement getNewcustomer() {
		return newcustomer;
	}

	//getter method for Enter customer name textfield
	public WebElement getEntercustomername() {
		return entercustomername;
	}

	//getter method for customer description text field
	public WebElement getEnterCustomerDescription() {
		return enterCustomerDescription;
	}

	//getter method for Select customer dropdown field
	public WebElement getSelectCustomer() {
		return selectCustomer;
	}
	
	//getter method for selectcustomer textfield(after clicking selectcustomer we will get etxtfield)
	public WebElement getSelectcustomerinput() {
		return selectcustomerinput;
	}
	
	//getter method for Ourcompany from the list
	public WebElement getOurCompany() {
		return ourCompany;
	}

	//getter method for Create Customer Button
	public WebElement getCreateCustomer() {
		return createCustomer;
	}

	//getter method for customername after creating customer(for comparsion)
	public WebElement getCustomername() {
		return customername;
	}

	//getters for project module-------------------------------------
	
	//getter method for new project button
	public WebElement getNewproject() {
		return newproject;
		
	
	}

	//getter method for Enterprojectname textfield
	public WebElement getEnterprojectname() {
		return enterprojectname;
	}

	//getter method for Selectcustomer Dropdown
	public WebElement getSelectcustomerproject() {
		return selectcustomerproject;
	}

	//getter method for selector customer input field (after click selectcustomer project)
	public WebElement getSelectcustomerprojectinput() {
		return selectcustomerprojectinput;
	}

	//getetr method for customer name from the list
	public WebElement getCustomernamefromdropdown() {
		return customernamefromdropdown;
	}

	//getter method for project description textfield
	public WebElement getProjectdescription() {
		return projectdescription;
	}

	//getter method for createproject button 
	public WebElement getCreateprojectButton() {
		return createprojectButton;
	}

	//getter method for projectname text from the result page(for comparison)
	public WebElement getPrjectnametext() {
		return prjectnametext;
	}
	
	//getters for Task module-------------------------------------

	//getter method for getnewtask button
	public WebElement getNewtask() {
		return newtask;
	}

	//getter method for selectcustomer dropdown
	public WebElement getSelectcustomerTask() {
		return selectcustomerTask;
	}

	//getter method for selectcustomer input(after click)
	public WebElement getSelectcustomerTaskinput() {
		return selectcustomerTaskinput;
	}

	//getter method for customername from the list
	public WebElement getCustomernamefromdropdowntask() {
		return customernamefromdropdowntask;
	}

	//getter method for select project dropdown
	public WebElement getSelectprojecttask() {
		return selectprojecttask;
	}
	
	//getter method for selectproejct input(after click)
	public WebElement getSelectprojectTaskinput() {
		return selectprojectTaskinput;
	}
	//getter method for project name from the list
	public WebElement getProjectnamefromdropdown() {
		return projectnamefromdropdown;
	}

	//getter method for Enter taskname textfield
	public WebElement getEntertaskname() {
		return entertaskname;
	}

	//getter method for createtask button
	public WebElement getCreatetaskButton() {
		return createtaskButton;
	}

	//getter method for taskname from the result page(for comparison)
	public WebElement getTasknametext() {
		return tasknametext;
	}
	
	
	
	
	
}
