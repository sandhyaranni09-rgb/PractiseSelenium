package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsDRY  {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@Test

	public void jsAlerts() {
		 
		BaseForJavaScript base = new BaseForJavaScript();
		
		base.preReq();

		wait = base.wait;
		driver = base.driver;
		WebElement jsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));

		jsAlertEle.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle = driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You successfully clicked an alert");
		System.out.println(message);

		base.tearDown();
	}

	@Test
	public void clickForJSConfirm() {
		
		BaseForJavaScript base = new BaseForJavaScript();
		base.preReq();
		
		wait = base.wait;
		driver = base.driver;
	

		WebElement clickJSConfirm = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));

		clickJSConfirm.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle= driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You clicked: Ok");
		System.out.println(message);

		base.tearDown();

	}
	
	@Test

	public void clickForJSPrompt() {

		BaseForJavaScript base = new BaseForJavaScript();
		
		base.preReq();
		
		wait = base.wait;
		driver = base.driver;

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Sandhya");

		alert.accept();

		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(msg, "You entered: Sandhya");
		
		System.out.println(msg);

		base.tearDown();
	}
}
