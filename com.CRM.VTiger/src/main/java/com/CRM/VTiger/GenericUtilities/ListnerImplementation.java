package com.CRM.VTiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"-->"+"Testscript Execution started");
		//start testscript execution
		test=reports.createTest(Methodname);
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"-->"+"Testscript pass");
		test.log(Status.PASS, "Testscript pass");
	}
	

	public void onTestFailure(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"-->"+"Testscript fail");
		test.log(Status.FAIL, "Testscript fail");
		test.log(Status.INFO, result.getThrowable());
		WebdriverUtility wutil=new WebdriverUtility();
		JavaUtility jutil=new JavaUtility(); 
		String screenshotname = Methodname+"-"+jutil.modifiedDate();
		try {
			String path = wutil.screenshot(BaseClass.sdriver, screenshotname);
			//copy the screenshot from screenshot folder then attach the SS into report
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	

	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"-->"+"Testscript skipped");
		test.log(Status.SKIP, "Testscript skipped");
		test.log(Status.INFO, result.getThrowable());
	
	
	}
	

	public void onStart(ITestContext context) {
		//String Methodname = result.getMethod().getMethodName();
		System.out.println("suite level Execution started");
		
		//Basic system configuration
	ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReport\\Report-"+new JavaUtility().modifiedDate()+".html");
	reporter.config().setDocumentTitle("Execution report");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setReportName("Vtiger Execution Report");
	
	//report configuration
	 reports=new ExtentReports();
	reports.attachReporter(reporter);
	reports.setSystemInfo("BaseUrl", "http://localhost:8888");
	reports.setSystemInfo("Browser", "chrome");
	reports.setSystemInfo("platform", "window");
	reports.setSystemInfo("Reporter name", "Debasish");
	
	
	}
	

	public void onFinish(ITestContext context) {
		System.out.println("suite level Execution Ended");
		
		//to consolidate the report and to replace the old report with new rerport
		reports.flush();
	}
	}


