package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseForJavaScript {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void preReq() {
		
		String browser = "Chrome";
//		
//		if (browser.equals("Chrome")) {
//		
//		driver = new ChromeDriver();
//		}
		
		switch (browser.toLowerCase()) {
		case "Chrome":
			driver = new ChromeDriver();
			
		case "Firefox":
			
			driver = new FirefoxDriver();
			
		case "Edge":
			driver = new EdgeDriver();
			
		case "Safari":
			driver = new SafariDriver();
			
		case "InternetExplorerDriver":
			driver = new InternetExplorerDriver();
			
			default:
				System.out.println("Browser not Supported !");
		
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://the-internet.herokuapp.com/");

		

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		System.out.println("Browser is closed");

	}
}
