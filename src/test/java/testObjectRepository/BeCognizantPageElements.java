package testObjectRepository;

import java.io.IOException;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import userDefinedLibraries.ExcelUtils;

public class BeCognizantPageElements {
	public WebDriver driver;
	public BeCognizantPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpaths
	@FindBy(xpath = "//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	public static WebElement accInfo;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']")
	public static WebElement name;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_secondary']")
	public static WebElement emailId;
	@FindBy(xpath = "(//i[@data-icon-name='CaretRight'])[1]")
	public static WebElement company;
	@FindBy(xpath = "//ul[@role='presentation']//span")
	public static List<WebElement> companyDrop;
	@FindBy(xpath = "(//*[@data-automation-id='CanvasSection'])[4]")
	public static WebElement nasdaqscroll;
	@FindBy(xpath = "//div[@class='stockValue_60e60a8c']")
	public static WebElement stockValue;
	@FindBy(xpath = "//div[@class='stockCurrency_60e60a8c']")
	public static WebElement stockValueUSD;

	// methods
	// Click on acc info
	public void clickOnAccInfo() {
		accInfo.click();
	}

	// get the name
	public String getName() {
		return name.getText();
	}

	// get the Email Id
	public String getEmailId() {
		return emailId.getText();
	}

	public void clickOnCompany() {
		company.click();
	}

	public void clickOnAcronym() {
		String acronym = "Acronyms";
		for (WebElement c : companyDrop) {
			if (c.getText().equals(acronym)) {
				c.click();
				break;
			}
		}
	}

	

	public void ValidateCogniHomePage() {
		String actualUrl = "https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";
//		if(driver.getCurrentUrl().equals(actualUrl)) {
//			System.out.println("Yes, it got redirected to Be. Cognizant Home Page.");
//		}else {
//			System.out.println("No,  it is not redirected to Be. Cognizant Home Page.");
//		}
		Assert.assertEquals(actualUrl, driver.getCurrentUrl());
		System.out.println("URL matching --> Part executed");
	}

	public void scrollBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", nasdaqscroll);
	}

	public String getStockValue() {
		return stockValue.getText();
	}

	public String getStockUSD() {
		return stockValueUSD.getText();
	}

	public void validatStockPrice() {
		String file = System.getProperty("user.dir") + "//testdata//CTSH.xlsx";
		int rows = 0;
		try {
			rows = ExcelUtils.getRowCount(file, "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int flag = 0;
		for (int i = 1; i < rows; i++) {
			String stock = stockValue.getText();
			String stockdata = null;
			try {
				stockdata = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Double.parseDouble(stockdata) == Double.parseDouble(stock)) {
				String date = null;
				try {
					date = ExcelUtils.getCellData(file, "Sheet1", i, 0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(date);
				flag++;
			}

		}
		if (flag == 0) {
			System.out.println("No data found!");
		}
	}

}
