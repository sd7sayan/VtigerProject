package vTigerr.OrganaizatiooonTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.VTiger.GenericUtilities.BaseClass;
import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;

import vtiger.ObjectRepositoryy.CreateNewOrganaizationpage;
import vtiger.ObjectRepositoryy.Homepage;
import vtiger.ObjectRepositoryy.OrganaizationInfopage;
import vtiger.ObjectRepositoryy.Organaizationpage;

public class CreateMultipleOrganizationTest extends BaseClass {
	@Test(dataProvider = "multipleData",dataProviderClass = ExcelFileUtility.class)
	public void verifyUserCreateMultipleOrganizationTest(String orgnamee) {
		JavaUtility jutil = new JavaUtility();

		ExcelFileUtility eutil = new ExcelFileUtility();
		//String orgname = eutil.getdataFromExcel("Sheet2", 0, 1) + jutil.getrandom();
		String orgname=orgnamee+jutil.getrandom();
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

