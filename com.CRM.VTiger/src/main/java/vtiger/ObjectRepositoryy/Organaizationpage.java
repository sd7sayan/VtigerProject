package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organaizationpage {
	
	@FindBy(xpath = "//img[contains(@title,'Crea')]")
	private WebElement orgLookupImg;
	
	public Organaizationpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOrgLookUpImg() {
		orgLookupImg.click();
	}

}
