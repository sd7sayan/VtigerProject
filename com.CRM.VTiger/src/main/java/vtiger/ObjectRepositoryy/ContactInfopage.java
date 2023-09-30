package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfopage {
	@FindBy(css = ".dvHeaderText") private WebElement contactHeader;
	
	public ContactInfopage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String contactHeader() {
		return contactHeader.getText();
	}

}
