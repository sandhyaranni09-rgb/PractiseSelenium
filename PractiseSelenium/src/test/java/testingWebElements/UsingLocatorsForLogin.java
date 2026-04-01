package testingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UsingLocatorsForLogin {

	@Test

	public void refactorCode() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");

		WebElement formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));

		formAuthentication.click();

		WebElement userNameText = driver.findElement(By.id("username"));

		userNameText.sendKeys("tomsmith");

		WebElement passwordText = driver.findElement(By.name("password"));

		passwordText.sendKeys("SuperSecretPassword!");

		WebElement loginButtonEle = driver.findElement(By.tagName("button"));

		loginButtonEle.click();

		WebElement linkEle = driver.findElement(By.linkText("Elemental Selenium"));

		linkEle.click();

		// driver.quit();

	}

}
