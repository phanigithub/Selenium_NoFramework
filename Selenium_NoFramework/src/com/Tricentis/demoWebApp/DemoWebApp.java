package com.Tricentis.demoWebApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebApp {

	WebDriver driver = null;
	
	By lnk_account = By.className("account");
	By btn_Address = By.linkText("Addresses");
	By lnk_wishList = By.className("ico-wishlist");
	
	public DemoWebApp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	protected void getTitleName() {
		System.out.println(driver.getTitle());
	}
	protected void viewaccountDetails() {
		driver.findElement(lnk_account).click();
		
	}
	protected Address addAddress() {
		driver.findElement(btn_Address).click();
		return new Address(driver);
	}
	
	protected void getCheckout() {
		System.out.println("Check out Not Implimented");
		driver.findElement(lnk_wishList).click();
	}
}
