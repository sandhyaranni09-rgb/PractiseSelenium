package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseForJavaScript {

	WebDriver driver;
	WebDriverWait wait;
	
	
	public void preReq() {
		
	 driver = new ChromeDriver();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://the-internet.herokuapp.com/");

		WebElement jsAlertsEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		jsAlertsEle.click();
		
		
	}

	
	public void tearDown() {
		
		driver.quit();
		System.out.println("Browser is closed");
		
	}
}
