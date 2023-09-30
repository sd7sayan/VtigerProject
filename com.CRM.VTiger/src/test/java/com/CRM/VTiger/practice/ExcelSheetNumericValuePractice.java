package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetNumericValuePractice {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(wb.getSheet("Sheet2").getRow(0).getCell(0));
		//String value = wb.getSheet("Sheet2").getRow(0).getCell(0).toString();
		System.out.println(value);
	
	
	}

}
