package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext context) {
		
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    
		repName = "exentReport_"+timestamp+".html";
		
		sparkReporter = new ExtentSparkReporter("./reports/"+repName);
		
		sparkReporter.config().setDocumentTitle("OpenCart Test Result");
		sparkReporter.config().setReportName("OpenCart funtional");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("UserName",System.getProperty("user.name"));
		extent.setSystemInfo("Enrvironment", "UAT");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	  }
	
	public void onTestSuccess(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    
	    test.log(Status.PASS, result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    
	    test.log(Status.FAIL, result.getName());
	    test.log(Status.INFO, result.getThrowable());
	    
	    
	    try {
	    	String imPath = new BaseClass().capScreen(result.getName());
	    	test.addScreenCaptureFromPath(imPath);
	    }catch(Exception e){
	    	e.getStackTrace();
	    }
		
	  }
	
	public void onTestSkipped(ITestResult result) {
	    test = extent.createTest(result.getClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    
	    test.log(Status.SKIP, result.getName());
	    test.log(Status.INFO, result.getThrowable());
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }




}//class
