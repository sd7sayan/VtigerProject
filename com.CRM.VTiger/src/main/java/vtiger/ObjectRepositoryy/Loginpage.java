package vtiger.ObjectRepositoryy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	//Identify the elements using selenium annotation and declare as private
	@FindBy(name = "user_name") private WebElement usernameEdt;
	
	@FindBy(name="user_password") private WebElement passwordEdt;
	
	@FindBy(id = "submitButton") private WebElement logInBtn;
	
	//Intialise the Elements
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This class help us to perform log in action	
	 * @param username
	 * @param password
	 */
	public void logIntoApp(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		logInBtn.click();
	}
	

}
