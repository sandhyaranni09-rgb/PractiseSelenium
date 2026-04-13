package testingWebElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

import managers.ExtentTestManager;

public class JavaScriptAlertsDRY extends BaseForJavaScript {

//	WebDriver driver;
//	WebDriverWait wait;

	@Test

	public void clickForJSAlerts() {

		// preReq();
		
		WebElement jsAlertsEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		jsAlertsEle.click();
		ExtentTestManager.log.info("Clicked on JavaScript Alerts");

		WebElement jsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));

		jsAlertEle.click();
		ExtentTestManager.log.info("Clicked on JS Alert");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle = driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You successfully clicked an alert");
		ExtentTestManager.log.info(message);
		//System.out.println(message);

		// tearDown();
	}

	@Test
	public void clickForJSConfirm() {

		// preReq();
		
		WebElement jsAlertsEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		jsAlertsEle.click();
		ExtentTestManager.log.info("Clicked on JavaScript Alerts");

		WebElement clickJSConfirm = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));

		clickJSConfirm.click();
		ExtentTestManager.log.info("Clicked on JS Confirm Alerts");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle= driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You clicked: Ok");
		ExtentTestManager.log.info(message);
		//System.out.println(message);

		// tearDown();

	}

	@Test

	public void clickForJSPrompt() {
		// preReq();
		
		WebElement jsAlertsEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='JavaScript Alerts']")));

		jsAlertsEle.click();
		ExtentTestManager.log.info("Clicked on JavaScript Alerts");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))).click();
		ExtentTestManager.log.info("Clicked on JS Prompt");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Sandhya");

		alert.accept();

		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(msg, "You entered: Sandhya");
		
		ExtentTestManager.log.info(msg);

		//System.out.println(msg);

		// tearDown();
	}
}
