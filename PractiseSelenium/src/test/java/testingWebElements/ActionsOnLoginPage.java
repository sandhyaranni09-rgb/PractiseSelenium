package testingWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionsOnLoginPage {
	
	@Test

	public void performActions() {
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement userNameEle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		
		Actions actions = new Actions(driver);
		
	
		actions.moveToElement(userNameEle)
		.click()
		.sendKeys("tomsmith")
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.perform();
		
		
		WebElement passwordEle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		
		actions.moveToElement(passwordEle)
		.click()
		.sendKeys("SuperSecretPassword!")
		.perform();
		
		
		WebElement loginButtonEle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
		actions.moveToElement(loginButtonEle)
		//.sendKeys(Keys.TAB)
		.click()
		.perform();
	}

}
