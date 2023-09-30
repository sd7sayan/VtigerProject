package com.CRM.VTiger.practice;

import org.testng.annotations.Test;

public class DtPractice {
	@Test(dataProvider = "data",dataProviderClass = DataProviderPractice.class)
	public void create(String mobile,int price) {
		System.out.println(mobile+"-->"+price);
	}

}
