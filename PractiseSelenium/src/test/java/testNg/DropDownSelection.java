package testNg;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

import java.util.Date;

import com.github.javafaker.Faker;

public class DropDownSelection {
	
	@Test

	public void DropDownSelectionTest() throws InterruptedException {

		WebDriver driver = new ChromeDriver(); 		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");
		
		driver.manage().window().maximize();
		
		WebElement signInOption =driver.findElement(By.xpath("//a[@data-test='nav-sign-in']"));
		
		signInOption.click();
		
		WebElement registerLink =driver.findElement(By.xpath("//a[@data-test='register-link']"));
		
		registerLink.click();
		
		WebElement firstName =driver.findElement(By.xpath("//input[@id='first_name']"));
		
		firstName.sendKeys(new Faker().name().firstName());
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
		
		lastName.sendKeys(new Faker().name().lastName());
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id='dob']"));	
		
		Date dob = new Faker().date().birthday();
		
		//dateOfBirth.sendKeys(new Faker().date().birthday().toString());	
		
		SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
		
		String formattedDOB = sDF.format(dob);
		
		dateOfBirth.sendKeys(formattedDOB);
		
		
		WebElement addressDetail = driver.findElement(By.xpath("//input[@id='address']"));						
		
		addressDetail.sendKeys(new Faker().address().buildingNumber());																	
		
		WebElement postalCode = driver.findElement(By.xpath("//input[@id='postcode']"));						
		
		postalCode.sendKeys(new Faker().address().zipCode());																			
		
		WebElement cityName = driver.findElement(By.xpath("//input[@id='city']"));								
		
		cityName.sendKeys(new Faker().address().cityName());																			
		
		WebElement stateName = driver.findElement(By.xpath("//input[@id='state']"));							
		
		stateName.sendKeys(new Faker().address().state());		
		
		WebElement countryName = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select cn = new Select(countryName);
		
		//cn.selectByValue("ZM");
		
		//cn.selectByIndex(0);
		
		List<WebElement> options = cn.getOptions();
		
		int size = options.size();
		
		cn.selectByIndex(size -2);
		
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phone']"));							
		
		//phoneNumber.sendKeys(new Faker().phoneNumber().cellPhone());	
		
		//phoneNumber.sendKeys(new Faker().number().digits(10));
		
		phoneNumber.sendKeys(new Faker().numerify("##########"));
		
		//phoneNumber.sendKeys("4318283891");
		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='email']"));						
		
		emailAddress.sendKeys(new Faker().internet().emailAddress());	
	
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));							
																										
		passwordField.sendKeys("ItsASecret");  	
		
		passwordField.sendKeys(Keys.TAB);
		
		WebElement registerButton = driver.findElement(By.xpath("//button[@data-test = 'register-submit']"));
		
		Thread.sleep(5000);
		
		registerButton.click();
	
		
	}


	}
		
