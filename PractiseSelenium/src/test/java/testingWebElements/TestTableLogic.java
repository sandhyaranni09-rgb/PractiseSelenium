package testingWebElements;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class TestTableLogic extends BaseForTestTable {
	@Test

	public void filterTest() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Java']"))).click();

		List<WebElement> columnValues = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));

		for (WebElement language : columnValues) {

			String value = language.getText();

//			Assert.assertEquals(value, "Java");
//			System.out.println("Test Passed");
			
			
			if(value.equals("Java")) {
				System.out.println("Test Passed");
			}
			else {
				System.out.println("Test Failed");
			}

			

		}

	}

	@Test
	public void levelFilterTest() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Intermediate']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Advanced']"))).click();
	}

	@Test
	public void minEnrollmentsTest() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-value='10000']"))).click();
	}

}
