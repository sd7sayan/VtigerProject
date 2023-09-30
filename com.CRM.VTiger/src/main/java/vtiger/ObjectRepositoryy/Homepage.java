package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.VTiger.GenericUtilities.WebdriverUtility;

public class Homepage extends WebdriverUtility {
	
	@FindBy(linkText = "Organizations") private WebElement orgLinkEdt;
	
	@FindBy(linkText = "Contacts") private WebElement contactLinkEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(xpath = "//a[.='Sign Out']") private WebElement signOutLink;

	public Homepage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	public void clickOrganaization() {
		orgLinkEdt.click();
	}
	
	public void clickContact() {
		contactLinkEdt.click();
	}
	
	public void logoutFromApp(WebDriver driver) {
		moveToElement(driver, AdministratorImg);
		signOutLink.click();
	}
	
	

}
