package testObjectRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userDefinedLibraries.ScreenShot;

public class AcronymPageElements {
	public WebDriver driver;
	
	// instantiate the webElements
	public AcronymPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "title_text")
	public static WebElement checkAcronym;
	@FindBy(id = "title_text")
	public static WebElement elementDisplayed;
	@FindBy(xpath = "//tbody//tr")
	public static List<WebElement> rowCount;
	@FindBy(xpath = "//tbody//tr[1]//td")
	public static List<WebElement> colCount;
	@FindBy(xpath = "(//span[@data-automationid='splitbuttonprimary']//span//span)[1]")
	public static WebElement becogni;
	
	// check for acronym Tool-tip
	public String checkAcronymToolTip() {
		return checkAcronym.getAttribute("title");
	}
	// check isElement is displayed 
	boolean isElementDisplayed() {
		return elementDisplayed.isDisplayed();
	}
	// display run-count
	public int displayrowCount() {
		int r = rowCount.size();
		return r;
	}
	// printing acronym data
	public void acronymDataPrint() throws IOException {
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\AcronymAppOutput.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet();
		for (int r = 1; r <= rowCount.size(); r++) {
			XSSFRow row=sheet.createRow(r-1);
			for (int c = 1; c <= colCount.size(); c++) {
				String listtxt = driver.findElement(By.xpath("//tbody//tr[" + r + "]//td[" + c + "]")).getText();
				System.out.print(listtxt + "   ");
				row.createCell(c-1).setCellValue(listtxt);
			}
			System.out.println();
		}
		ScreenShot.TakeScreenShot(driver, "acronymData");
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	// click on beCognizant URL
	public void clickOnBeCogni() {
		becogni.click();
	}
}
