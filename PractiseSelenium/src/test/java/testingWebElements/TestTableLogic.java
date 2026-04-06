package testingWebElements;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class TestTableLogic extends BaseForTestTable {
	@Test

	public void filterTest() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Java']"))).click();

		// Thread.sleep(5000);

		List<WebElement> columnValues = driver
				.findElements(By.xpath("//table/tbody/tr[not(contains(@style,'display: none;'))]/td[3]"));

		for (WebElement language : columnValues) {

			String value = language.getText();

//			Assert.assertEquals(value, "Java");
//			System.out.println("Test Passed");

			if (value.equals("Java")) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}

		}

	}

	@Test
	public void levelFilterTest() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Intermediate']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Advanced']"))).click();

		List<WebElement> columnValues = driver
				.findElements(By.xpath("//table/tbody/tr[not(contains(@style,'display: none;'))]/td[4]"));

		for (WebElement level : columnValues) {

			String value = level.getText();

			Assert.assertEquals(value, "Beginner");
			System.out.println("Test Passed");

//			if (value.equals("Beginner")) {
//				System.out.println("Test Passed");
//			} else {
//				System.out.println("Test Failed");
//			}
		}
	}

	@Test
	public void minEnrollmentsTest() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-value='10000']"))).click();
	}

}
