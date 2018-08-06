package com.Tricentis.demoWebApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By btn_Save = By.className("save-address-button");
	
 

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
		 selCountry.selectByIndex(1);
		 
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 WebDriverWait wdwait = new WebDriverWait(driver, 10);
		 
		 wdwait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(lst_State, By.tagName("option")));
		 
		 Select selstate = new Select(driver.findElement(lst_State));
		 selstate.selectByVisibleText("Guam");
		 
		 driver.findElement(txt_city).sendKeys("sw.Glos");
		 driver.findElement(lst_address1).sendKeys("KRK Schools Road");
		 driver.findElement(lst_address2).sendKeys("KRK  Township");
		 driver.findElement(txt_postalCode).sendKeys("999999");
		 driver.findElement(txt_PhoneNumber).sendKeys("999999");
		 driver.findElement(txt_Fax).sendKeys("999999");
		 driver.findElement(btn_Save).click();
		 
		 		
		
	}
	
}
