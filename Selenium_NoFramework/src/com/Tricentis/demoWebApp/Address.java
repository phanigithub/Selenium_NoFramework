package com.Tricentis.demoWebApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Address {

	WebDriver driver = null;
	
	By btn_addAddress = By.className("add-address-button");
	By txt_FirstName = By.id("Address_FirstName");
	By txt_LastName = By.id("Address_LastName");
	By txt_eMail = By.id("Address_Email");
	By txt_Company = By.id("Address_Company");
	By lst_Country = By.id("Address_CountryId");
	By lst_State = By.id("Address_StateProvinceId");
	By txt_city = By.id("Address_City");
	By lst_address1 = By.id("Address_Address1");
	By lst_address2 = By.id("Address_Address2");
	By txt_postalCode = By.id("Address_ZipPostalCode");
	By txt_PhoneNumber = By.id("Address_PhoneNumber");
	By txt_Fax = By.id("Address_FaxNumber");
	By lnk_account = By.className("account");
	
 

	public Address(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	

	protected void addNewAddress() {
		driver.findElement(btn_addAddress).click();
		
		 driver.findElement(txt_FirstName).sendKeys("Krisshna");
		 driver.findElement(txt_LastName).sendKeys("Raama");
		 driver.findElement(txt_eMail).sendKeys(driver.findElement(lnk_account).getText());
		 driver.findElement(txt_Company).sendKeys("KRK Schools");
		 Select selCountry = new Select(driver.findElement(lst_Country));
		 selCountry.selectByIndex(5);
		 Select selCity = new Select(driver.findElement(txt_city));
		 selCity.selectByIndex(5);
		 
		 driver.findElement(lst_address1).sendKeys("KRK Schools Road");
		 driver.findElement(lst_address2).sendKeys("KRK  Township");
		 driver.findElement(txt_postalCode).sendKeys("999999");
		 driver.findElement(txt_PhoneNumber).sendKeys("999999");
		 driver.findElement(txt_Fax).sendKeys("999999");
		 
		 		
		
	}
	
}
