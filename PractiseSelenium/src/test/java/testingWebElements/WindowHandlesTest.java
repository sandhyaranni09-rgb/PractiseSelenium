package testingWebElements;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandlesTest {

	@Test

	public void windowTest() {

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demoqa.com/browser-windows");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabButton"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton"))).click();

		String parentWindowHandle = driver.getWindowHandle();

		System.out.println("Handle : " + parentWindowHandle);

		Set<String> allHandles = driver.getWindowHandles();

		for (String handle : allHandles) {

			if (!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle);

				String message = driver.findElement(By.id("sampleHeading")).getText();

				Assert.assertEquals(message, "This is a sample page");

				System.out.println("New Tab Handle : "+ handle );
			}

		}

	}

}
