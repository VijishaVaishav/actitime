package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
import com.beust.jcommander.Parameter;

public class BaseClass {

	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	//chages for crossbt
	//public WebDriver driver;

	public static WebDriver driver;
//	@Parameters("browser")//cbt
	@BeforeClass
	//public void openBrowser(String browser)//---cbt
	public void openBrowser()
	{
		Reporter.log("Open browser");
		//driver=new ChromeDriver();
		
			driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void login() throws IOException
	{
		Reporter.log("Login");
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin();

	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout");
		HomePage h=new HomePage(driver);
		h.setLogout();
	}

	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("Closebrowser");
		driver.close();
	}
}
