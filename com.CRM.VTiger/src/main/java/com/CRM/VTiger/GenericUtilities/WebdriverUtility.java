   package com.CRM.VTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility { 
	
	/**
	 * This method maximize the browser window
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method minimize the browser window
	 * @param driver
	 */
	
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method wait the webdriver for some time until the condition met
	 * @param driver
	 */
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ipathconstant.implicitwaitDuration));
	}
	
	public void visibility(WebDriver driver,WebElement elemnt) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOf(elemnt));
	}
	
	public void elementToBeClickable(WebDriver driver,WebElement elemnt) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(elemnt));
	
	}
	
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Ipathconstant.explicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	
	}
	
	public void handelDropdown(WebElement elemnt,int indexNo) {
		Select s=new Select(elemnt);
		s.selectByIndex(indexNo);
	}
	
	public void handelDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void handelDropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void frameByindex(WebDriver driver,int indexNo) {
		driver.switchTo().frame(indexNo);
	}
	
	/**
	 * By using this method we handel the frame element using nameOrid
	 * @param driver
	 * @param nameOrId
	 */
	public void frameBynameOrid(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * By using this method we handel the frame element using Webelement
	 * @param driver
	 * @param element
	 */
	
	public void frameByelement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void parentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void rightClickAnywhere(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void doubleClickAnywhere(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragAnddrop(WebDriver driver,WebElement srcElement,WebElement destElement) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();
		
	}
	
	public void windowHandling(WebDriver driver,String partialTitle) {
		//capture all the window ids
		
		Set<String> id = driver.getWindowHandles();
		
		//navigate to each window
		for(String wid:id) {
			
			//navigate to each window capture the title
			String currentTitle = driver.switchTo().window(wid).getTitle();
			
			//compare the title with the required window title
			if(currentTitle.contains(partialTitle)) {
				break;
			}
		}
		
	}
	
	public String screenshot(WebDriver driver,String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		JavaUtility jutil=new JavaUtility();
		String currentdate = jutil.modifiedDate();
		
		File dest=new File("./Screenshot/"+currentdate+screenshotname+".png");
		
		Files.copy(src, dest);
		
		return dest.getAbsolutePath();//extent report
	}
	public String screenshot(WebElement element,String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)element;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		JavaUtility jutil=new JavaUtility();
		String currentdate = jutil.modifiedDate();
		
		File dest=new File("./Screenshot/"+currentdate+screenshotname+".png");
		
		Files.copy(src, dest);
		
		return dest.getAbsolutePath();//extent report
	}
	
	
	

}
