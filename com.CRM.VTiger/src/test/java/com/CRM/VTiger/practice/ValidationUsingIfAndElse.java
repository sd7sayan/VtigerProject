package com.CRM.VTiger.practice;

import org.testng.annotations.Test;

public class ValidationUsingIfAndElse {
	@Test
	public void create() {
		String actual="Maharaja";
		String expected="raja";
		if(actual.equals(expected)) {
			System.out.println("pass");
		}
		else
			System.out.println("fail");
			
	}

}
