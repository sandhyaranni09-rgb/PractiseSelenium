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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label/input[@value='Java']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Beginner']"))).click();

		WebElement resetbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Reset']")));

		String reset = resetbutton.getText();

		Assert.assertEquals(reset, "Reset");

		resetbutton.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Reset']"))).isDisplayed();

		String language = driver.findElement(By.xpath("//input[@name='lang' and @checked]")).getAttribute("value");

		Assert.assertEquals(language, "Any");

//		String checkbox = driver.findElement(By.xpath("//input[@name='level' and @checked]")).getAttribute("value");
//
//		Assert.assertEquals(checkbox, "Beginner");

//		WebElement checkbox = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='level' and @value='Beginner']")));
//				
//			Assert.assertTrue(checkbox.isSelected(), "Beginner checkbox is not selected");

		By beginner = By.xpath("//input[@name='level' and @value='Beginner']");
		wait.until(ExpectedConditions.elementToBeSelected(beginner));
		Assert.assertTrue(driver.findElement(beginner).isSelected(), "Beginner not selected");

		By intermediate = By.xpath("//input[@name='level' and @value='Intermediate']");
		wait.until(ExpectedConditions.elementToBeSelected(intermediate));
		Assert.assertTrue(driver.findElement(intermediate).isSelected(), "Intermediate not selected");

		By advanced = By.xpath("//input[@name='level' and @value='Advanced']");
		wait.until(ExpectedConditions.elementToBeSelected(advanced));
		Assert.assertTrue(driver.findElement(advanced).isSelected(), "Advanced not selected");

		String minEnrollments = driver.findElement(By.xpath("//div[@data-value='any']")).getText();

		Assert.assertEquals(minEnrollments, "Any", "Min enrollments not reset");

	}
}
