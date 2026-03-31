package testingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeleniumActions extends BaseForJavaScript{

	@Test
	public void dragAndDropTest()  {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Drag and Drop']"))).click();
		
		Actions actions = new Actions(driver);
		WebElement boxAEle= wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='column-a']")));
		
		WebElement boxBEle= wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='column-b']")));
		
		
		actions.dragAndDrop(boxAEle, boxBEle).perform();
		
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='column-b']"), "A"));
		
		System.out.println("Successfully Dragged and Dropped");
		
		
	}
}
