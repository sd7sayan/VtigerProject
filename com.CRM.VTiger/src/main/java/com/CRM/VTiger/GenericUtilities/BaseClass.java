package com.CRM.VTiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepositoryy.Homepage;
import vtiger.ObjectRepositoryy.Loginpage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;//listners
	public Fileutility futil=new Fileutility();
	public WebdriverUtility wutil=new WebdriverUtility();
	
	@BeforeSuite(groups = {"RegressionSuite","smokesuite"})
	public void bsConfig() {
		System.out.println("create database conn");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"RegressionSuite","smokesuite"})
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		//String BROWSER = futil.getdataFromPropertyFile("browser");
		String BROWSER=System.getProperty("browser");
		String URL = futil.getdataFromPropertyFile("url");
		//Runtime polymorphism or method overRiding
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else  if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else
			System.out.println("Invalid Browser");
		sdriver=driver;//listners
		wutil.maximize(driver);
		wutil.wait(driver);
		driver.get(URL);
	
	}
	@BeforeMethod(groups = {"RegressionSuite","smokesuite"})
	public void bmConfig() throws Throwable {
		String UN = futil.getdataFromPropertyFile("username");
		String PW = futil.getdataFromPropertyFile("password");
		Loginpage lp=new Loginpage(driver);
		lp.logIntoApp(UN, PW);
		
	}
	
	@AfterMethod(groups = {"RegressionSuite","smokesuite"})
	public void amConfig() {
		Homepage hp=new Homepage(driver);
		hp.logoutFromApp(driver);
	}
	@AfterClass(groups = {"RegressionSuite","smokesuite"})
	public void acConfig() {
		driver.quit();
	}
	@AfterSuite(groups = {"RegressionSuite","smokesuite"})
	public void asConfig() {
		System.out.println("close DB Connection");
	}
}
