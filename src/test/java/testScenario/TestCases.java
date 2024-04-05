package testScenario;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testObjectRepository.AcronymPageElements;
import testObjectRepository.BeCognizantPageElements;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExtentReport;

public class TestCases extends DriverSetup {
	BeCognizantPageElements beCogniElement;
	AcronymPageElements acronymElement;
	private ExtentReports extent;
	// helps to generate the logs in the test report.
	private ExtentTest test;
	ExtentReports extreportobj = new ExtentReports();
	String screenshotPath;

	@Parameters({ "browser" })
	@BeforeClass
	public void driverconfig(@Optional("defaultBrowser")String browser) {
		// Instantiate driver
		driver = DriverSetup.driverInstantiate(browser);
		System.out.println("Browser opened with the provided url");
		//extent = extreportobj.getReport();
		extent=extreportobj.tryResolveMediaPath(null);
		System.out.println("Report object Initialised");
	}

	@Test(priority = 0)
	public void clickOnAccInfo() {
		beCogniElement = new BeCognizantPageElements(driver);
		test = extent.createTest("Click on acc info");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		beCogniElement.clickOnAccInfo();
		test.pass("Acc info got clicked");
	}

	@Test(priority = 1)
	public void getName() {
		test = extent.createTest("Get the Name");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String name = beCogniElement.getName();
		System.out.println("User Name : " + name);
		test.pass("Name is taken and printed");
	}

	@Test(priority = 2)
	public void getEmailId() {
		test = extent.createTest("Get the Email Id");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String emailId = beCogniElement.getEmailId();
		System.out.println("Email Id : " + emailId);
		test.pass("Email Id is taken and printed");
	}

	@Test(priority = 3)
	public void ClickOnCompany() {
		test = extent.createTest("Click on company");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		beCogniElement.clickOnCompany();
		test.pass("clicked on company");
	}

	@Test(priority = 4)
	public void clickOnAcronym() {
		test = extent.createTest("Click on Acronym");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		beCogniElement.clickOnAcronym();
		test.pass("clicked on Acronym");
	}

	@Test(priority = 5)
	public void acronymTooltip() {
		acronymElement = new AcronymPageElements(driver);
		test = extent.createTest("check acronym captured");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Tooltip: " + acronymElement.checkAcronymToolTip());
		test.pass("Tool Tip captured");
	}

	@Test(priority = 6)
	public void isAcronymDisp() {
		test = extent.createTest("Acronym is displayed");
		test.log(Status.INFO, "Starting the test case");
		System.out.println("Yes, Acronym is displayed : " + acronymElement.elementDisplayed.getText());
		test.pass("Acronym is disaplayed");
	}

	@Test(priority = 7)
	public void rowCount() {
		test = extent.createTest("check for rowcount");
		test.log(Status.INFO, "Starting the test case");
		System.out.println("Total Row count is :  "+acronymElement.displayrowCount());
		test.pass("Row count is calculated");
	}

	/*
	 * @Test(priority=8) public void colCount() { test =
	 * extent.createTest("check for col Count"); test.log(Status.INFO,
	 * "Starting the test case"); System.out.println(element.colCount);
	 * test.pass("col count is calculated"); }
	 */
	@Test(priority = 9)
	public void acronymDataPrint() {
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		try {
			acronymElement.acronymDataPrint();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// to display data
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.pass("Acronym data is displayed");

	}

	@Test(priority = 10)
	public void ClickOnBeCogni() {
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		acronymElement.clickOnBeCogni();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.pass("Acronym data is displayed");

	}

	@Test(priority = 11)
	public void ValidateCogniHomePage() {
		test = extent.createTest("display the acronym data");
		test.log(Status.INFO, "Starting the test case");
		beCogniElement.ValidateCogniHomePage();
		test.pass("Acronym data is displayed");
	}

	@Test(priority = 12)
	public void scrollToBottom() {
		test = extent.createTest("scroll to bottom");
		test.log(Status.INFO, "Starting the test case");
		beCogniElement.scrollBottom();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.pass("Scrolled to bottom of the page");
	}

	@Test(priority = 13)
	public void getStockPriceUSD() {
		test = extent.createTest("get stock value");
		test.log(Status.INFO, "Starting the test case");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Current stock price : " + beCogniElement.getStockValue() + " " + beCogniElement.getStockUSD());

		test.pass("Stock value is disaplayed");
	}

	@Test(priority = 14)
	public void compareStockPrice() {
		test = extent.createTest("validate stock price");
		test.log(Status.INFO, "starting the test case");
		beCogniElement.validatStockPrice();
		test.pass("Stock value is validated!");
	}

	@AfterClass
	public void closeBrow() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driverTearDown();
		System.out.println("Closed the browser");
	}

}
