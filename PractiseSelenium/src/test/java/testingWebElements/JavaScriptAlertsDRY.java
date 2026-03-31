package testingWebElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsDRY extends BaseForJavaScript {

//	WebDriver driver;
//	WebDriverWait wait;

	@Test

	public void jsAlerts() {

		// preReq();

		WebElement jsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));

		jsAlertEle.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle = driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You successfully clicked an alert");
		System.out.println(message);

		// tearDown();
	}

	@Test
	public void clickForJSConfirm() {

		// preReq();

		WebElement clickJSConfirm = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));

		clickJSConfirm.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		// WebElement resultEle= driver.findElement(By.xpath("//p[@id='result']"));
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You clicked: Ok");
		System.out.println(message);

		// tearDown();

	}

	@Test

	public void clickForJSPrompt() {
		// preReq();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Sandhya");

		alert.accept();

		String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(msg, "You entered: Sandhya");

		System.out.println(msg);

		// tearDown();
	}
}
