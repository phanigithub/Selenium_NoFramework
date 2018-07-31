package com.Tricentis.demoWebApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScript {
	public static void main(String[] args) {
		
		WebDriver driver = null ;
		//String strHomeURL = "http://demowebshop.tricentis.com/";
		System.setProperty("webdriver.chrome.driver", "E:\\Phani\\Projects\\Testing\\Selenium\\BrowserDriver\\Chrome\\chromedriver.exe");		
		
		HomePage home_page = new HomePage(driver);
		home_page.launchApp("CHROME");
		home_page.register();
		home_page.validate_Register("Your registration completed");
		
		
	}

}
