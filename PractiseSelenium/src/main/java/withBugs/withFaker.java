package withBugs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

public class withFaker {


		public static void main(String[] args) {

			WebDriver driver = new ChromeDriver(); 																	

			driver.get("https://with-bugs.practicesoftwaretesting.com/#/");			
			
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement signIn = wait.until(
			    ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='nav-sign-in']"))
			);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", signIn);
			
//			// Step 1: wait for visibility
//			 wait.until(
//			    ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='nav-sign-in']"))
//			);
//			
//			WebElement signIn = wait.until(
//				    ExpectedConditions.visibilityOfElementLocated(
//				        By.xpath("//a[@data-test='nav-sign-in']")
//				    )
//				);
//
//			// Step 2: wait for clickable
//			//wait.until(ExpectedConditions.elementToBeClickable(signIn));
//
//			signIn.click();
			
//			// Click Sign In
//			WebElement signInOption = wait.until(
//			    ExpectedConditions.elementToBeClickable(By.xpath("//li[4][@class='nav-item']"))
//			);
//
//			//WebElement signInOption = driver.findElement(By.xpath("//a[@data-test='nav-sign-in']"));				
//																								
//			signInOption.click();	
			
			// Click Register
			WebElement registerOption = wait.until(
			    ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='register-link']"))
			);

			//WebElement registerOption = driver.findElement(By.xpath("//a[@data-test='register-link']"));																									

			registerOption.click(); 																				

//			WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));						
//
//			firstName.sendKeys(new Faker().name().firstName());	
			Faker faker = new Faker();
			
			String firstName;
			do {
			    firstName = faker.name().firstName();
			} while (firstName.length() != 6); // change length if needed

			firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();

			WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first_name']"));
			firstNameField.sendKeys(firstName);

//			WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));							
//			
//			lastName.sendKeys(new Faker().name().lastName()); 																				
			
			// Last Name
			String lastName;
			do {
			    lastName = faker.name().lastName();
			} while (lastName.length() != 8); // change length if needed

			lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

			WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last_name']"));
			lastNameField.sendKeys(lastName);
			
			WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id='dob']"));							
			
			//dateOfBirth.sendKeys("1950-12-30");	
			
			dateOfBirth.sendKeys(new Faker().date().birthday().toString());	
			
			WebElement addressDetail = driver.findElement(By.xpath("//input[@id='address']"));						
			
			addressDetail.sendKeys(new Faker().address().buildingNumber());																	
			
			WebElement postalCode = driver.findElement(By.xpath("//input[@id='postcode']"));						
			
			postalCode.sendKeys(new Faker().address().zipCode());																			
			
			WebElement cityName = driver.findElement(By.xpath("//input[@id='city']"));								
			
			cityName.sendKeys(new Faker().address().cityName());																			
			
			WebElement stateName = driver.findElement(By.xpath("//input[@id='state']"));							
			
			stateName.sendKeys(new Faker().address().state());																			
			
			WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phone']"));							
			
			phoneNumber.sendKeys("437-808-3891");																	
			
			WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email']"));						
			
			emailAddress.sendKeys("sandhyaranni09@gmail.com");		
			
			
			
		
			
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));							
																											
			password.sendKeys("ItsASecret!!!");  																		

		}
	}

