package acronymDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acronymDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://be.cognizant.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		
		Actions action = new Actions(driver);
		
		WebElement accDetails = driver.findElement(By.xpath("//*[@id=\"O365_MainLink_Me\"]"));
		action.moveToElement(accDetails).perform();
		String hoverText=accDetails.getAttribute("title");
		System.out.println(hoverText);
		
		
		// add explicit wait to this element
		WebElement element = driver.findElement(By.xpath("//*[@id=\"spTopPlaceholder\"]/div/div[2]/div/div/div/div/div/div/div[2]/button/span/i"));
		element.click();
		
		String acronym="Acronyms";
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"presentation\"]//li//div//a//div//span"));
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equals(acronym))
				list.get(i).click();
		}
		
		WebElement title=driver.findElement(By.xpath("//*[@id=\"title_text\"]"));
		String titletxt=title.getAttribute("title");
		System.out.println(titletxt);
		
		
		
	}



}
