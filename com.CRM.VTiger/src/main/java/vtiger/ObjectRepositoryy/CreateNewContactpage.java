package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactpage {
	@FindBy(name = "lastname") private WebElement lastnameTextEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtnEdt;
	
	public CreateNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createcontact(String contactName) {
		lastnameTextEdt.sendKeys(contactName);
		saveBtnEdt.click();
	}

}
