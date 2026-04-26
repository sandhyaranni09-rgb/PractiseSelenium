package testingWebElements;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SortForTestTable extends BaseForTestTable{
	
	@Test
	
	public void sortByEnrol () {
		
		
		driver.findElement(By.xpath("//select[@id='sortBy']")).click();

		driver.findElement(By.xpath("//select[@id='sortBy']/option[@value='col_enroll']")).click();
		
		
	} 
	
	

}
