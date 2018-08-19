package com.Tricentis.demoWebApp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

abstract public class demoWebAppUtils {
	
	public static void captureScreen1(WebDriver driver,String spath) {
		
		File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFileToDirectory(fs, new File("C:\\Temp"+spath+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(""+e.getMessage());
		}
		
	}

}
