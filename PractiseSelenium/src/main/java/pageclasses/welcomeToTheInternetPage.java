package pageclasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class welcomeToTheInternetPage {
	
	WebDriver driver = new ChromeDriver();
	By formAuthenticationLink = By.linkText("Form Authentication");
	By headingTitle = By.tagName("h1");
	
	public void clickFormAuthentication() {
		driver.findElement(formAuthenticationLink).click();
	}

	
	public String getFormAuthenticationPageTitle() {
		return driver.findElement(headingTitle).getText();
		
	} 
}

