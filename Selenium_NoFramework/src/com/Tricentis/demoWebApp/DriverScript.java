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
		
		@SuppressWarnings("unused")
		DemoWebApp DWAPage = home_page.validate_Register("Your registration completed");
		DWAPage.viewaccountDetails();
		
		Address addresss = DWAPage.addAddress();
		addresss.addNewAddress();
		addresss.addNewAddress();
		DWAPage.getCheckout();
		home_page.NavigatePage("ELECTRONICS>Camera, photo");
		home_page.PrintItemsList();
		home_page.viewItem("Camcorder");
		
		home_page.captureScreen("Z1");
		
	//	ExcelUtil.createExcel("TestExcel",true);
		
		
	}

}
