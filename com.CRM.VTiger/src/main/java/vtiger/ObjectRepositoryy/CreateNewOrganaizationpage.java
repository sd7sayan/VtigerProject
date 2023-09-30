package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganaizationpage {
	
	@FindBy(name = "accountname") private WebElement orgnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganaizationpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createOrg(String orgname) {
		orgnameEdt.sendKeys(orgname);
		saveBtn.click();
	}

}
