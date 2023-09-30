package com.CRM.VTiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	
	
	@DataProvider()
	public Object[][] data() {
		Object[][] dt=new Object[2][2];
		dt[0][0]="samsung";
		dt[0][1]=10000;
		dt[1][0]="Nokia";
		dt[1][1]=20000;
		return dt;
	}

}
