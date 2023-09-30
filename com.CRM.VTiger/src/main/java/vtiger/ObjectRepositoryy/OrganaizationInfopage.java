package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganaizationInfopage {
	@FindBy(css = ".dvHeaderText") private WebElement orgHeaderText;
	
	public OrganaizationInfopage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String orgHeder() {
		return orgHeaderText.getText();
	}

}
