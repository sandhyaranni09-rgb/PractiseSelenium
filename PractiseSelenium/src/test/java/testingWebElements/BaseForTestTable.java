package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseForTestTable {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void preReq() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/");
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
