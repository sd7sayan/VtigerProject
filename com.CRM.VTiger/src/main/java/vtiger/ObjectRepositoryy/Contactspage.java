package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {
	
	@FindBy(xpath = "//img[contains(@title,'Crea')]")
	private WebElement contactLookUpImg;
	
	public Contactspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void contactlookUpimg() {
		contactLookUpImg.click();
	}

}
