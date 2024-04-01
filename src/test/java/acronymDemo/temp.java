package acronymDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class temp {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\\\"spPageCanvasContent\\\"]/div/div/div/div/div/div[2]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		
		Thread.sleep(4000);
		
		
		String s =driver.findElement(By.xpath("//div[@class='stockValue_60e60a8c']")).getText();
		System.out.println(s);
		
		
		
		
		
	
	}
	
	
}
	