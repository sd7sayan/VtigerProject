package com.CRM.VTiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void create() {
		/*//contains level comparison
		String actual="maharaja";
		String expected="raja";
		//Assert.assertTrue(actual.contains(expected));
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual, expected);
		//sa.assertTrue(actual.contains(expected));
		
		System.out.println("pass");
		
		sa.assertAll();*/
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		ele.sendKeys("iphone14");
		//ele.submit();
		driver.findElement(By.id("nav-search-submit-button")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	}

}
