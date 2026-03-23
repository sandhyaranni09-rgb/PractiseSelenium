package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicCheckBox {

	@Test
	public void dynamicCheckTest() {

		WebDriver driver = new ChromeDriver();

		// Go to URL
		driver.navigate().to("https://the-internet.herokuapp.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Go to Dynamic COntrols and click
		WebElement dynamicControls = driver.findElement(By.xpath("//a[text()= 'Dynamic Controls']"));

		dynamicControls.click();

		WebElement checkboxEle = driver.findElement(By.xpath("//div[@id = 'checkbox']"));

		checkboxEle.click();

		checkboxEle.isSelected();
		System.out.println("Checkbox is selected");

		// WebElement removebuttonEle =
		// driver.findElement(By.xpath("//button[text()='Remove']"));

		WebElement removebuttonEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Remove']")));
		removebuttonEle.click();
		wait.until(ExpectedConditions.textToBePresentInElement(removebuttonEle, "Add"));

		WebElement addbuttonEle = driver.findElement(By.xpath("//button[text()='Add']"));
		wait.until(ExpectedConditions.elementToBeClickable(addbuttonEle));

		String check = addbuttonEle.getText();

		Assert.assertEquals(check, "Add");
		System.out.println("Add button appears");

		WebElement messageEle = driver.findElement(By.xpath("//p[@id='message']"));
		wait.until(ExpectedConditions.textToBePresentInElement(messageEle, "It's gone!"));
		System.out.println("Message \"It's gone!\" is displayed");

		driver.quit();

	}
}
