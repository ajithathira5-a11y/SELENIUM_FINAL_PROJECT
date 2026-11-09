package com.indusvalley.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.indusvalley.page.IndusValleyCart;
import com.indusvalley.page.IndusValleyHome;
import com.indusvalley.page.IndusValleyLogin;

public class IndusValleyBase {
	
	public static WebDriver driver;
	
	public IndusValleyHome ho;
	
	public IndusValleyCart ca;
	
	public WebDriverWait wait;
	
	public IndusValleyLogin lo;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	
	
	@BeforeTest
	public void setup()
	{
		reporter = new ExtentSparkReporter("./Report/TheIndusValleyReport.html");
		reporter.config().setDocumentTitle("TheIndusValley_Automation");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Athira Ajith K");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.theindusvalley.in");
		
			
	}
	
	@BeforeMethod()
	public void before(Method mthd)
	{
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		ho = new IndusValleyHome(driver,wait);
		
		ca = new IndusValleyCart(driver,wait);
		
		lo = new IndusValleyLogin(driver,wait);
		
		test = extent.createTest(mthd.getName());

		
	}
	
		
	@AfterMethod
	public void reportGenerate(ITestResult result) throws IOException
	{
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "failed test case is "+result.getName());
			test.log(Status.FAIL, "failed test reason is "+result.getThrowable());
			String Screenshotpath = screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(Screenshotpath);
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,"test case skiped is"+result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"test case passed is"+result.getName());
		}
	}
	
	public static String screenshotMethod(WebDriver driver,String scnname) throws IOException
	{
		File src =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = "./ScreenShot/"+scnname+".png";
		FileHandler.copy(src,new File(dest));
	
	    return "../ScreenShot/" + scnname + ".png";
		
	}
	
	
	@AfterTest()
	public void teardown()
	{
		
		extent.flush();
		
	}
	
	@DataProvider(name = "SearchItems")
	public Object[] getdata() throws IOException
	{
		String st = "src\\main\\resources\\inputssss.xlsx";
		
//	    System.out.println("Working directory: " + System.getProperty("user.dir"));
		
		return com.indusvalley.utils.IndusValleyUtils.getTestData(st,"Sheet3");
	}
	
	

}
