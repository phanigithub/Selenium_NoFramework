package com.Tricentis.demoWebApp;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	By topMenu = By.className("top-menu");
	
	By itemOne = By.className("product-item");
	
	By itemOne1 = By.className("product-title");
	
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
		driver.manage().window().maximize();
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
	
	public void NavigatePage(String nav) {
		Actions act = new Actions(driver);
		String nav1 [] = nav.split(">") ;
		for(String itemNav : nav1){
			System.out.println(itemNav+driver.findElement(By.linkText(itemNav)));
			act.moveToElement(driver.findElement(By.linkText(itemNav))).build().perform();
		}
		act.click().perform();
	}
	public void PrintItemsList() {
		List<WebElement> itemOnes = driver.findElements(itemOne);
		System.out.println(itemOnes.size());
		for(WebElement x : itemOnes) {
			System.out.println(x.findElement(By.tagName("h2")).getText());
		}
		
	}
	public void viewItem(String itemName) {
		// TODO Auto-generated method stub
		List<WebElement> itemOnes = driver.findElements(itemOne1);
		for(WebElement we : itemOnes) {
			System.out.println(we.getText().equals(itemName));
			if(we.getText().equals(itemName)){
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", we);
				captureScreen("Z11");
				captureScreenSelection(we,"T1");
				we.findElement(By.tagName("a")).click();
				return ;
			}
		}
		 
	}
	
	private void captureScreenSelection(WebElement we,String tpath)  {
		// TODO Auto-generated method stub
		
		File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File nfs = new File("c:\\temp\\"+tpath+".png");
		
		
		BufferedImage bim = null;
		try {
			bim = ImageIO.read(fs);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Point pt = (Point)we.getLocation();
		
		int eleWidth = we.getSize().getWidth();
		int eleHeight = we.getSize().getHeight();
		
		BufferedImage bim1=null;
		try {
			System.out.println(pt.getX()+"/"+pt.getY()+"/"+eleWidth+"/"+eleHeight);
			System.out.println(bim.getWidth()+"/"+bim.getHeight()+"/"+bim.TRANSLUCENT);
			bim1 = bim.getSubimage(pt.getX(),pt.getY(),eleWidth-100,11);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("--"+e1.getMessage()+e1.getCause());
		}
		try {
			ImageIO.write(bim1, "png", fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileUtils.copyFile(fs, nfs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(nfs.getPath());
		
	}
	public void captureScreen(String spath) {
		// TODO Auto-generated method stub
		
		File fs = null;
		File nf = null;
		try {
			fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			 nf = new File("C:\\Temp\\"+spath+".png");
			FileUtils.copyFileToDirectory(fs, nf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
		}
		System.out.println(nf.getPath());
		
		
	}
	
	
	
	

}
