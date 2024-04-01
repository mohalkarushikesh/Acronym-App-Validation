package testScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testObjectRepository.Elements;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExtentReportsforProj;

public class acronym extends DriverSetup{
	public static WebDriver driver;
	Elements element;	
	private ExtentReports extent;
	// helps to generate the logs in the test report.
	private ExtentTest test;
	ExtentReportsforProj extreportobj = new ExtentReportsforProj();
	String screenshotPath;
	
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void driverconfig(String browser) {
		// Instantiate driver
		driver = DriverSetup.driverInstantiate(browser);
		System.out.println("Browser opened with the provided url");
		extent = extreportobj.setExtentReport();
		System.out.println("Report object Initialised");
	}
	
	@Test(priority=0)
	public void clickOnAccInfo() {
		
		test = extent.createTest("Click on acc info");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element=new Elements(driver);
		element.clickOnAccInfo();
		test.pass("Acc info got clicked");
	}
	
	@Test(priority=1)
	public void getName() {
		test = extent.createTest("Get the Name");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String name=element.getName();
		System.out.println(name);
		test.pass("Name is taken");
	}
	
	@Test(priority=2)
	public void getEmailId() {
		test = extent.createTest("Get the Email Id");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String emailId=element.getEmailId();
		System.out.println(emailId);
		test.pass("Email Id is taken");
	}
	
	@Test(priority=3)
	public void ClickOnCompany() {
		test = extent.createTest("Click on company");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.clickOnCompany();
		test.pass("clicked on company");
	}
	
	@Test(priority=4)
	public void clickOnAcronym() {
		test = extent.createTest("Click on Acronym");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.clickOnAcronym();
		test.pass("clicked on Acronym");
	}
	
	@Test(priority=5)
	public void acronymTooltip() {
		test = extent.createTest("check acronym captured");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(element.checkAcronymToolTip());
		test.pass("Tool Tip captured");	
	}
	
	@Test(priority=6)
	public void isAcronymDisp() {
		test = extent.createTest("Acronym is displayed");
		test.log(Status.INFO, "Starting the test case");
		System.out.println(element.elementDisplayed.getText());
		test.pass("Acronym is disaplayed");
	}
	
	
	@Test(priority=7)
	public void rowCount(){
		test = extent.createTest("check for rowcount");
		test.log(Status.INFO, "Starting the test case");
		System.out.println(element.displayrowCount());
		test.pass("row count is calculated");
	}
	/*
	@Test(priority=8)
	public void colCount() {
		test = extent.createTest("check for col Count");
		test.log(Status.INFO, "Starting the test case");
		System.out.println(element.colCount);
		test.pass("col count is calculated");
	}
	*/
	@Test(priority=9)
	public void acronymDataPrint(){
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		element.acronymDataPrint();
		// to display data
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass("acronym data is displayed");
		
	}
	@Test(priority=10)
	public void ClickOnBeCogni(){
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		element.clickOnBeCogni();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass("acronym data is displayed");
		
	}
	@Test(priority=11)
	public void ValidateCogniHomePage(){
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		element.ValidateCogniHomePage();
		test.pass("acronym data is displayed");	
	}
	
	@Test(priority=12)
	public void scrollToBottom() {
		test = extent.createTest("scroll to bottom");
		test.log(Status.INFO, "Starting the test case");
		element.scrollBottom();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.pass("scrolled to bottom of the page");	
	}
	
	@Test(priority=13)
	public void getStockPriceUSD() {
		test = extent.createTest("get stock value");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stock price : " + element.getStockValue() +" "+ element.getStockUSD());
		
		test.pass("stock value is disaplayed");
	}
	
	
	@AfterClass
	public void closeBrow() {
		// Close the browser after all the steps of scenario
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverTearDown();
		System.out.println("Closed the browser");
	}
	
	
	
	
}
