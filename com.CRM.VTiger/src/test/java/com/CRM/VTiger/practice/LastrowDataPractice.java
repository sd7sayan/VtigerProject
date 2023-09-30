package com.CRM.VTiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class LastrowDataPractice {
	@Test
	public void dt() throws Throwable, Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Dataprivider");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		System.out.println(lastrow+"\n"+lastcell);

	}

}
