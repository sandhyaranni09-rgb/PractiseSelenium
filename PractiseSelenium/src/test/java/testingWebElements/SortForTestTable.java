package testingWebElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	}


