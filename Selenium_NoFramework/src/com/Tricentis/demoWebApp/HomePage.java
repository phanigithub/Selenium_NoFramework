package com.Tricentis.demoWebApp;


import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	private WebDriver driver;
	private final String launchURL = "http://demowebshop.tricentis.com/";
	
	By lnk_Register = By.className("ico-register");
	By rdo_Gender = By.name("Gender");
	By txt_FirstName = By.id("FirstName");
	By txt_LastName = By.id("LastName");
	By txt_email = By.id("Email");
	By txt_Password = By.id("Password");
	By txt_PasswordCnf = By.id("ConfirmPassword");
	By btn_Register = By.name("register-button");
	By msg_result = By.className("result");
	By btn_Continue = By.className("register-continue-button");
	
	
	
	HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	protected void launchApp(String browser) {
		
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			driver.get(launchURL);
			break;
		case "IE":
			System.err.println(browser.toUpperCase()+"Not Available yet");
		case "FIREFOX":
			System.err.println(browser.toUpperCase()+"Not Available yet");
		default:
			System.err.println("UnKnown Browser!!!");
			break;
		} 
	}
	public void register() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((WebElement) driver.findElement(lnk_Register)).click();
		List<WebElement> oRdoGender =  driver.findElements(rdo_Gender);
		oRdoGender.get(0).click();
		
		Date dt = new Date();
		String secCnt = String.valueOf(dt.getSeconds()*dt.getMinutes());
		((WebElement) driver.findElement(txt_FirstName)).sendKeys("QWERTY");
		((WebElement) driver.findElement(txt_LastName)).sendKeys("abc");
		((WebElement) driver.findElement(txt_email)).sendKeys("QWERTY"+secCnt+"@ABC.COM");
		((WebElement) driver.findElement(txt_Password)).sendKeys("onetwo");
		((WebElement) driver.findElement(txt_PasswordCnf)).sendKeys("onetwo");
		
		((WebElement) driver.findElement(btn_Register)).click();

		
		
		
		
		
	}
//	private <T> getElement(By element) {
//		return driver.findElements(element);
//	}
	public DemoWebApp validate_Register(String expected) {
		// TODO Auto-generated method stub
		String msgToValidate = ((WebElement) driver.findElement(msg_result)).getText();
		System.out.println(msgToValidate);
		System.out.println(expected);
		if(msgToValidate.equalsIgnoreCase(expected)){
			System.out.println("Values are Matched !!!");
			driver.findElement(btn_Continue).click();
		}
		else {
			System.err.println("****** Values Not Matched !!! *********");
		}
		return new DemoWebApp(driver);
	}
	
	
	
	
	

}
