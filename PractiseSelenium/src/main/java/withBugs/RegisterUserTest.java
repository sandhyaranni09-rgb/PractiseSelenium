package withBugs;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterUserTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver(); 																	// open browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");											// Go to withbugs page

		WebElement signInOption = driver.findElement(By.xpath("//a[@data-test='nav-sign-in']"));				// Go to Sign-In (Find 	the element)
																							
		signInOption.click();																					// click on Sign in

		WebElement registerOption = driver.findElement(By.xpath("//a[@data-test='register-link']"));			// Go to Register your Account																							

		registerOption.click(); 																				// Click on Register

		WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));						// Go to FirstName

		firstName.sendKeys("Sandhya");																			// Supply First Name

		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));							// Go to last Name
		
		lastName.sendKeys("Rani"); 																				// Supply First Name
		
		WebElement dateOfBirth = driver.findElement(By.xpath("// input[@id='dob']"));							// Go to DOB
		
		dateOfBirth.sendKeys("1950-12-30");																		// Supply DOB
		
		WebElement addressDetail = driver.findElement(By.xpath("// input[@id='address']"));						// Go to Address
		
		addressDetail.sendKeys("Lynch Street");																	// Supply Address
		
		WebElement postalCode = driver.findElement(By.xpath("// input[@id='postcode']"));						// Go to postalCode
		
		postalCode.sendKeys("L6W 0C7");																			// Supply postalCode
		
		WebElement cityName = driver.findElement(By.xpath("// input[@id='city']"));								// Go to city
		
		cityName.sendKeys("Brampton");																			// Supply cityName
		
		WebElement stateName = driver.findElement(By.xpath("// input[@id='state']"));							// Go to countryName
		
		stateName.sendKeys("Ontario");																			// Supply countryName
		
		WebElement phoneNumber = driver.findElement(By.xpath("// input[@id='phone']"));							// Go to Phone
		
		phoneNumber.sendKeys("437-808-3891");																	// Supply phoneNumber
		
		WebElement emailAddress = driver.findElement(By.xpath("// input[@id='email']"));						// Go to E-mail
		
		emailAddress.sendKeys("sandhyaranni09@gmail.com");														// Supply E-mail Address
		
		WebElement password = driver.findElement(By.xpath("// input[@id='password']"));							// Go to password
																										
		password.sendKeys("ItsASecret!!!");  																	// Supply E-mail Address	

	}
}
