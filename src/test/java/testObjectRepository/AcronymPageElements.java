package testObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcronymPageElements {
	public WebDriver driver;
	
	// instantiate the webElements
	public AcronymPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='title_text']")
	public static WebElement checkAcronym;
	@FindBy(xpath = "//div[@id='title_text']")
	public static WebElement elementDisplayed;
	@FindBy(xpath = "//tbody//tr")
	public static List<WebElement> rowCount;
	@FindBy(xpath = "//tbody//tr[1]//td")
	public static List<WebElement> colCount;
	@FindBy(xpath = "(//span[@data-automationid='splitbuttonprimary']//span//span)[1]")
	public static WebElement becogni;
	

	public String checkAcronymToolTip() {
		return checkAcronym.getAttribute("title");
	}

	boolean isElementDisplayed() {
		return elementDisplayed.isDisplayed();
	}

	public int displayrowCount() {
		int r = rowCount.size();
		return r;
	}

	public void acronymDataPrint() {
		for (int r = 1; r <= rowCount.size(); r++) {
			for (int c = 1; c <= colCount.size(); c++) {
				String listtxt = driver.findElement(By.xpath("//tbody//tr[" + r + "]//td[" + c + "]")).getText();
				System.out.print(listtxt + "   ");
			}
			System.out.println();
		}
	}

	public void clickOnBeCogni() {
		becogni.click();
	}
}
