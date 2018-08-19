package com.Tricentis.demoWebApp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilCreatePOI {


	public static void main(String...arg) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String string = "C:\\Users\\Krishnaa\\Desktop\\1.xlsx";
		Workbook wbook = new XSSFWorkbook();
		Sheet sht = wbook.createSheet("Test");
		
		
	    CreationHelper createHelper = wbook.getCreationHelper();

	    
		Row row = sht.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(1500);
		row.createCell(1).setCellValue(1.2);
		
		row.createCell(2).setCellValue(
		         createHelper.createRichTextString("This is a string"));
		    row.createCell(3).setCellValue(true);
		
		    try(OutputStream fileOut = new FileOutputStream("workbook.xlsx")){
		    	wbook.write(fileOut);
		    	wbook.close();
		    }
		    wbook.close();
	}
}
