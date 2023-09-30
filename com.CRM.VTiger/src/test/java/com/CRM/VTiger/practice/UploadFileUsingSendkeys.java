package com.CRM.VTiger.practice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFileUsingSendkeys {
       
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/3FR2/Desktop/FileeeeUpload.html");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		File f=new File("./src/test/resources/REAL ADDRESS 2.png");
		String path = f.getAbsolutePath();
		element.sendKeys(path);
	
	
	}

}
