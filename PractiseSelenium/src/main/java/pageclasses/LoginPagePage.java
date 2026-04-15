package pageclasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPagePage {
	
	WebDriver driver= new ChromeDriver();

	By userName=By.id("username");
	By password= By.id("password");
	By loginButton = By.className("radius");
	
	public void enterUserName() {
		
		driver.findElement(userName).sendKeys("tomsmith");
	}

	public void enterPassword() {
		driver.findElement(password).sendKeys("SuperSecretPassword!");
	}
	
	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}
}
