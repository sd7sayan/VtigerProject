package com.CRM.VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * This class consist of generic method to insert,update and fetch the data from excel file
 * @author Debasish
 *
 */

public class ExcelFileUtility {
	
	public String getdataFromExcel(String sheetname,int rowno,int cellno) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	
	
	}
	
	public void updateExcelData(String sheetname,int rowno,int cellno,String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(Ipathconstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rowno).createCell(cellno).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Ipathconstant.excelfilepath);
		wb.write(fos);
	}
	
	/**
	 * By using this method fetch multiple cell data from excel sheet
	 * @return
	 * @throws Throwable
	 */
	@DataProvider
	public Object[][] multipleData() throws Throwable {
		FileInputStream fis=new  FileInputStream(Ipathconstant.excelfilepath);
		Sheet sh = WorkbookFactory.create(fis).getSheet("Dataprivider");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] dt=new Object[lastrow][lastcell];
		DataFormatter df=new DataFormatter();
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				dt[i][j]=df.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		return dt;
	
	}

}
