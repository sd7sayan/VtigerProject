package com.CRM.VTiger.practice;

import com.CRM.VTiger.GenericUtilities.ExcelFileUtility;
import com.CRM.VTiger.GenericUtilities.Fileutility;
import com.CRM.VTiger.GenericUtilities.JavaUtility;

public class PracticegenericUtility {

	public static void main(String[] args) throws Throwable {
		Fileutility futil=new Fileutility();
		String BROWSER = futil.getdataFromPropertyFile("browser");
		System.out.println(BROWSER);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String contactname = eutil.getdataFromExcel("Sheet2", 0, 0);
		System.out.println(contactname);
		
		JavaUtility jutil=new JavaUtility();
		String dt = jutil.sysdateTime();
		System.out.println(dt);
		String dat = jutil.modifiedDate();
		System.out.println(dat);	
	}
	
}
