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

		List<WebElement> tableValue = driver.findElements(By.xpath("//div[contains(@style,'display:')]"));

		for (WebElement row : tableValue) {

			String value = row.getText();

			Assert.assertEquals(value, "No matching courses.");

			// System.out.println(value);
		}

	}

	@Test

	public void resetButtonTest() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label/input[@value='Java']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()=' Beginner']"))).click();

//		WebElement resetbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Reset']")));
//		
//		Assert.assertEquals(resetbutton, "Reset");

//		resetbutton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Reset']"))).isDisplayed();

		String language = driver.findElement(By.xpath("//input[@name='lang' and @checked]")).getAttribute("value");

		Assert.assertEquals(language, "Any");

		String checkbox = driver.findElement(By.xpath("//input[@name='level' and @checked]")).getAttribute("value");

		Assert.assertEquals(checkbox, "Beginner");

//		WebElement checkbox = driver.findElement(
//			    By.xpath("//input[@name='level' and @value='Beginner']")
//			);
//
//			Assert.assertTrue(checkbox.isSelected(), "Beginner checkbox is not selected");
//			
//			WebElement checkbox1 = driver.findElement(
//				    By.xpath("//input[@name='level' and @value='Intermediate']")
//				);
//
//				Assert.assertTrue(checkbox1.isSelected(), "Intermediate checkbox is not selected");
//		
//		WebElement checkbox2 = driver.findElement(
//			    By.xpath("//input[@name='level' and @value='Advanced']")
//			);
//
//			Assert.assertTrue(checkbox2.isSelected(), "Advanced checkbox is not selected");
//			
//			
//			String enrolValue= driver.findElement(By.xpath("//div/span[@class='dropdown-label']")).getText();
//			
//			Assert.assertEquals(enrolValue, "Any");
//			

	}
}
