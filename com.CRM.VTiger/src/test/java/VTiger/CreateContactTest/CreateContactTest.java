package VTiger.CreateContactTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.Fileutility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.GenericUtilities.WebdriverUtility;

import vtiger.ObjectRepositoryy.ContactInfopage;
import vtiger.ObjectRepositoryy.Contactspage;
import vtiger.ObjectRepositoryy.CreateNewContactpage;
import vtiger.ObjectRepositoryy.Homepage;
import vtiger.ObjectRepositoryy.Loginpage;
@Listeners(com.CRM.VTiger.GenericUtilities.ListnerImplementation.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = {"RegressionSuite","smokesuite"} , retryAnalyzer = com.CRM.VTiger.GenericUtilities.RetryAnalyser.class)
	public void verifyUsercreateContactTest() throws Throwable {
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String name = eutil.getdataFromExcel("Sheet2", 0, 0) + jutil.getrandom();
		
		//Click on contact link
		Homepage hp = new Homepage(driver);
		hp.clickContact();
		Reporter.log("contact link clicked",true);
		//Assert.fail();
		
		//click on contact look up image
		Contactspage cp = new Contactspage(driver);
		cp.contactlookUpimg();
		Reporter.log("contact lookup image clicked",true);
		
		//Create contact with mandatory fields
		CreateNewContactpage cncp = new CreateNewContactpage(driver);
		cncp.createcontact(name);
		//Assert.fail();
		
		//Fetch created contact
		ContactInfopage cip = new ContactInfopage(driver);
		String contactheader = cip.contactHeader();

		//Validate contact created or not
		Assert.assertTrue(contactheader.contains(name));
		Reporter.log("validation pass",true);
		System.out.println("pass");
	}
	@Test
	public void create() {
		System.out.println("Execute");
	}

}
