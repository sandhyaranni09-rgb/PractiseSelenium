package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecureArea {
	
	WebDriver driver = new ChromeDriver();
	
	By PageTitle = By.tagName("h2");
	
	public void getSecureAreaPageTitle() {
		
		driver.findElement(PageTitle).getText();
	}

}
