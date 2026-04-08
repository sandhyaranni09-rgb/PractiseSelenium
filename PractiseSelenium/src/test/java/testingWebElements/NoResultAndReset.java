package testingWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoResultAndReset extends BaseForTestTable {
	
	@Test
	public void noResultTest() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label/input[@value='Any']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()=' Beginner']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-value='50000']"))).click();
		
		List <WebElement> tableValue= driver.findElements(By.xpath("//div[contains(@style,'display:')]"));
		
		for(WebElement row: tableValue) {
			
			String value=row.getText();
			
			Assert.assertEquals(value, "No matching courses.");
			
			//System.out.println(value);
		}
		
		
	}

}
