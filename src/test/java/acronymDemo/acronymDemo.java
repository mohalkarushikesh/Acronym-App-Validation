package acronymDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acronymDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://be.cognizant.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Actions action = new Actions(driver);
		
		/*
		WebElement accDetails = driver.findElement(By.xpath("//*[@id=\"O365_MainLink_Me\"]"));
		action.moveToElement(accDetails).perform();
		String hoverText=accDetails.getAttribute("title");
		System.out.println(hoverText);
		*/
		//click on account
		Thread.sleep(10000);
		WebElement accInfoClick = driver.findElement(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", accInfoClick);
		//wait.until(ExpectedConditions.elementToBeClickable(accInfoClick));
		accInfoClick.click();
		
		//get the name 
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.xpath("//div[@id=\"mectrl_currentAccount_primary\"]"));
		//wait.until(ExpectedConditions.visibilityOf(name));
		System.out.println(name.getText());
		//get the email id 
		WebElement emailId = driver.findElement(By.xpath("//div[@id=\"mectrl_currentAccount_secondary\"]"));
		//wait.until(ExpectedConditions.visibilityOf(emailId));
		System.out.println(emailId.getText());
		//click on company 
		WebElement element = driver.findElement(By.xpath("(//i[@data-icon-name=\"CaretRight\"])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		//get the list under company 
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"presentation\"]//span"));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
		String acronym="Acronyms";
		for(WebElement l:list){
			if(l.getText().equals(acronym)) {
				l.click();
				break;
			}
		}

		//acronym
		WebElement checkAcronym=driver.findElement(By.xpath("//div[@id='title_text']"));
		boolean isElementDisplayed = driver.findElement(By.xpath("//div[@id='title_text']")).isDisplayed();
		System.out.println(isElementDisplayed);
		
		String checkAcronymtxt=checkAcronym.getAttribute("title");
		System.out.println(checkAcronymtxt);
		
		
		int rowCount = driver.findElements(By.xpath("//tbody//tr")).size();
		System.out.println("count of Acronyms data : " + rowCount);
		
		int colCount = driver.findElements(By.xpath("//tbody//tr[1]//td")).size();
		
		for(int r=1;r<=rowCount;r++) {
			for(int c=1;c<=colCount;c++) {
				String listtxt=driver.findElement(By.xpath("//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(listtxt + "   ");
			}
			System.out.println();
		}
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("(//span[@data-automationid=\"splitbuttonprimary\"]//span//span)[1]")).click();
		
		String actualUrl="https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx";	
		
		if(driver.getCurrentUrl().equals(actualUrl)) {
			System.out.println("Yes, it got redirected to Be. Cognizant Home Page.");
		}else {
			System.out.println("No,  it is not redirected to Be. Cognizant Home Page.");
		}
		
		
		// get the cognizant stock price 
		
		// verify same stock price present in any other years or month
		
		// diff browser
		
		// include testng 
		
		// data driven approch 
		
		
		
		
		driver.close();
		
	}



}
