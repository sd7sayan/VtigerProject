package vTigerr.OrganaizatiooonTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.Fileutility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;
import com.CRM.VTiger.GenericUtilities.WebdriverUtility;

import vtiger.ObjectRepositoryy.CreateNewOrganaizationpage;
import vtiger.ObjectRepositoryy.Homepage;
import vtiger.ObjectRepositoryy.Loginpage;
import vtiger.ObjectRepositoryy.OrganaizationInfopage;
import vtiger.ObjectRepositoryy.Organaizationpage;
@Listeners(com.CRM.VTiger.GenericUtilities.ListnerImplementation.class)
public class CreateOrganaizationTest extends BaseClass {
	@Test(groups = "smokesuite")
	public void verifyUserCreateOrganizationTest() throws Throwable {

		JavaUtility jutil = new JavaUtility();

		ExcelFileUtility eutil = new ExcelFileUtility();
		String orgname = eutil.getdataFromExcel("Sheet2", 0, 1) + jutil.getrandom();
		
		Homepage hp = new Homepage(driver);
		hp.clickOrganaization();

		Organaizationpage op = new Organaizationpage(driver);
		op.clickOrgLookUpImg();

		CreateNewOrganaizationpage cnop = new CreateNewOrganaizationpage(driver);
		cnop.createOrg(orgname);

		OrganaizationInfopage oinp = new OrganaizationInfopage(driver);
		String orgHeader = oinp.orgHeder();

		Assert.assertTrue(orgHeader.contains(orgname));
		System.out.println("pass");


	}

}
