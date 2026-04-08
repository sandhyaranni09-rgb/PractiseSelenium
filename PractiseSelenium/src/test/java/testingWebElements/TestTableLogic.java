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

		List<WebElement> enrolValues = driver
				.findElements(By.xpath("//table//tr[not(contains(@style,'display: none;'))]/td[5]"));

		for (WebElement enroll : enrolValues) {

			String value = enroll.getText();

			int numValues = Integer.valueOf(value);

			Assert.assertTrue(numValues >= 10000);
			System.out.println("Valid Enrollment: " + numValues);

		}

	}

	@Test

	public void combinationFilterTest() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Python']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Intermediate']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Advanced']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@data-value='10000']"))).click();
		
		List <WebElement> rows = driver.findElements(By.xpath("//table//tr[not(contains(@style,'display: none;'))]"));
		
		
		for (WebElement row: rows) {
			
			String language = row.findElement(By.xpath("//table//tr[not(contains(@style,'display: none;'))]/td[3]")).getText();
			
			String level = row.findElement(By.xpath("//table//tr[not(contains(@style,'display: none;'))]/td[4]")).getText();
			
			String enrollment = row.findElement(By.xpath("//table//tr[not(contains(@style,'display: none;'))]/td[5]")).getText();
			
			int enrolNum= Integer.valueOf(enrollment);
			
			Assert.assertEquals(language, "Python");
			//System.out.println("Language is "+ language);
			Assert.assertEquals(level, "Beginner");
			//System.out.println("Level is " + level);
			Assert.assertTrue(enrolNum>=10000);
			//System.out.println("Enrollment Number is " + enrolNum);
			
		}

	}

}
