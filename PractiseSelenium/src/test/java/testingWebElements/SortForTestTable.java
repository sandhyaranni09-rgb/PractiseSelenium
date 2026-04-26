package testingWebElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortForTestTable extends BaseForTestTable {

	@Test

	public void sortByEnrol() {

		driver.findElement(By.xpath("//select[@id='sortBy']")).click();

		driver.findElement(By.xpath("//select[@id='sortBy']/option[@value='col_enroll']")).click();

		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));

		// Get actual list values from table

		List<Integer> actualList = new ArrayList<>();
		for (WebElement el : elements) {
			String values = el.getText();
			int number = Integer.parseInt(values.replaceAll("[^0-9]", ""));
			actualList.add(number);
		}

		List<Integer> sortedList = new ArrayList<>(actualList);
		Collections.sort(sortedList);

		System.out.println("Actual List from the Table is" + actualList);
		System.out.println("Sorted List" + sortedList);

		Assert.assertEquals(actualList, sortedList, "List is not sorted!");

	}

	@Test
		public void sortByCourse() {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='sortBy']"))).click();
	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='sortBy']/option[@value='col_course']"))).click();
	
			List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
	
			List<String> actualList = new ArrayList<>();
	
			for (WebElement i : elements) {
				String values = i.getText();
				actualList.add(values);
			}
	
			List<String> sortedList = new ArrayList<>(actualList);
			Collections.sort(sortedList);
	
			System.out.println("Actual List " + actualList);
			System.out.println("Sorted List " + sortedList);
	
			Assert.assertEquals(actualList, sortedList, "List is not sorted!");
	
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()=' Java']"))).click();
			
			List<WebElement> filteredElements = driver.findElements(By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]/td[2]"));
	
			List<String> actualFilteredList = new ArrayList<>();
	
			for (WebElement fil : filteredElements) {
				String filteredvalues = fil.getText();
				actualFilteredList.add(filteredvalues);
			}
	
			List<String> sortedFilteredList = new ArrayList<>(actualFilteredList);
			Collections.sort(sortedFilteredList);
	
			System.out.println("Actual List " + actualFilteredList);
			System.out.println("Sorted List " + sortedFilteredList);
	
			Assert.assertEquals(actualFilteredList, sortedFilteredList, "List is not sorted!");
			
			
		}
	
	}
