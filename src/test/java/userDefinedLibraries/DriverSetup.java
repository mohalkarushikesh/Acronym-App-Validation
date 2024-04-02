package userDefinedLibraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {

	public static WebDriver driver;
	public static String url = "https://be.cognizant.com/";
	public static String browserType;

	public static WebDriver driverInstantiate(String browser) {
		browserType = browser;

		if (browserType.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		return driver;
	}

	public static void driverTearDown() {
		driver.quit();
	}

}
