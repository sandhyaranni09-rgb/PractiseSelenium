package withBugs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterUserTest {

	public static void main(String[] args) {

		// open browser
		WebDriver driver = new ChromeDriver();
		// Go to withbugs page
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");
		// Go to Sign-In (Find the element)
		WebElement signInOption = driver.findElement(By.xpath("//a[@data-test='nav-sign-in']"));
		// click on Sign in
		signInOption.click();
		// Go to Register your Account
		WebElement registerOption = driver.findElement(By.xpath("//a[@data-test='register-link']"));
		// Click on Register
		registerOption.click();
		// Go to FirstName
		WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
		// Supply First Name
		firstName.sendKeys("Sandhya");
		// Go to last Name
		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
		// Supply First Name
		lastName.sendKeys("Rani");
		// Go to DOB
		WebElement dateOfBirth = driver.findElement(By.xpath("// input[@id='dob']"));
		// Supply DOB
		dateOfBirth.sendKeys("1950-12-30");
		// Go to Address
		WebElement addressDetail = driver.findElement(By.xpath("// input[@id='address']"));
		// Supply Address
		addressDetail.sendKeys("Lynch Street");
		// Go to postalCode
		WebElement postalCode = driver.findElement(By.xpath("// input[@id='postcode']"));
		// Supply postalCode
		postalCode.sendKeys("L6W 0C7");
		// Go to city
		WebElement cityName = driver.findElement(By.xpath("// input[@id='city']"));
		// Supply cityName
		cityName.sendKeys("Brampton");
		// Go to countryName
		WebElement stateName = driver.findElement(By.xpath("// input[@id='state']"));
		// Supply countryName
		stateName.sendKeys("Ontario");
		// Go to Phone
		WebElement phoneNumber = driver.findElement(By.xpath("// input[@id='phone']"));
		// Supply phoneNumber
		phoneNumber.sendKeys("437-808-3891");
		// Go to E-mail
		WebElement emailAddress = driver.findElement(By.xpath("// input[@id='email']"));
		// Supply E-mail Address
		emailAddress.sendKeys("sandhyaranni09@gmail.com");
		// Go to password
		WebElement password = driver.findElement(By.xpath("// input[@id='password']"));
		// Supply E-mail Address
		password.sendKeys("ItsASecret!!!");

	}
}
