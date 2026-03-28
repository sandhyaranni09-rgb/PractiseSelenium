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

public class JavaScriptAlerts {

	@Test

	public void jsAlerts() {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://the-internet.herokuapp.com/");

		// WebElement jsAlertsEle= driver.findElement(By.xpath("//a[text()='JavaScript
		// Alerts']")).click();

		WebElement jsAlertsEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		jsAlertsEle.click();

		WebElement jsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));

		jsAlertEle.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle = driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You successfully clicked an alert");
		System.out.println(message);

		driver.quit();
	}

	@Test
	public void clickForJSConfirm() {
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://the-internet.herokuapp.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();

		WebElement clickJSConfirm = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));

		clickJSConfirm.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle= driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You clicked: Ok");
		System.out.println(message);

		driver.quit();

	}
	
	@Test

	public void clickForJSPrompt() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Sandhya");

		alert.accept();

		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(msg, "You entered: Sandhya");
		
		System.out.println(msg);

		driver.quit();
	}
}
