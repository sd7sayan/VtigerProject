package com.CRM.VTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class PracticeNG {
	@Test(priority = 1,invocationCount = 1)
	public void create() {
		System.out.println("create");
		Assert.fail();
	}
	@Test(dependsOnMethods = "create",alwaysRun = true)
	public void update() {
		System.out.println("update");
	}
	@Test(priority = 1)
	public void delete() {
		System.out.println("deleted");
	}

}
