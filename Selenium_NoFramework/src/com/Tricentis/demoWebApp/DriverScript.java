package com.Tricentis.demoWebApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScript {
	public static void main(String[] args) {
		
		String strHomeURL = "http://demowebshop.tricentis.com/";
		System.setProperty("webdriver.chrome.driver", "E:\\Phani\\Projects\\Testing\\Selenium\\BrowserDriver\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(strHomeURL);
		
		System.out.println(driver.getTitle());
	}

}
