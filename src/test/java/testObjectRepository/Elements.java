package testObjectRepository;

import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Elements {
	public WebDriver driver;
	
	//xpaths
	@FindBy(xpath="//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']") 
	public static WebElement accInfo;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']") 
	public static WebElement name;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']") 
	public static WebElement emailId;
	@FindBy(xpath="(//i[@data-icon-name='CaretRight'])[1]")
	public static WebElement company;
	@FindBy(xpath="//ul[@role='presentation']//span")
	public static List<WebElement> companyDrop;
	@FindBy(xpath="//div[@id='title_text']")
	public static WebElement checkAcronym;
	@FindBy(xpath="//div[@id='title_text']")
	public static WebElement elementDisplayed;
	@FindBy(xpath="//tbody//tr")
	public static List<WebElement> rowCount;
	@FindBy(xpath="//tbody//tr[1]//td")
	public static List<WebElement> colCount;
	@FindBy(xpath="(//span[@data-automationid='splitbuttonprimary']//span//span)[1]")
	public static WebElement becogni;
	
	
	
	//instantiate the webElements
	public Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//methods
	//Click on acc info 
	public void clickOnAccInfo() {
		accInfo.click();
	}
	//get the name 
	public String getName() {
		return name.getText();
	}
	//get the Email Id
	public String getEmailId() {
		return emailId.getText();
	}
	
	public void clickOnCompany(){
		company.click();
	}
	
	public void clickOnAcronym() {
		String acronym="Acronyms";
		for(WebElement c:companyDrop){
			if(c.getText().equals(acronym)) {
				c.click();
				break;
			}
		}
	}
	
	public String checkAcronymToolTip() {
		return checkAcronym.getAttribute("title");
	}
	
	boolean isElementDisplayed() {
		return elementDisplayed.isDisplayed();		
	}
	
	public int displayrowCount() {										
			int r=	rowCount.size();
			return r;
	}

	public void acronymDataPrint() {
		for(int r=1;r<=rowCount.size();r++) {
			for(int c=1;c<=colCount.size();c++) {
				String listtxt=driver.findElement(By.xpath("//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(listtxt + "   ");
			}
			System.out.println();
		}
	}
	
	public void clickOnBeCogni() {
		becogni.click();
	}
	
	public void ValidateCogniHomePage() {
		String actualUrl="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";	
//		if(driver.getCurrentUrl().equals(actualUrl)) {
//			System.out.println("Yes, it got redirected to Be. Cognizant Home Page.");
//		}else {
//			System.out.println("No,  it is not redirected to Be. Cognizant Home Page.");
//		}
		Assert.assertEquals(actualUrl, driver.getCurrentUrl());
		System.out.println("URL matching --> Part executed");
	}
	
}
