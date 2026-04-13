package testingWebElements;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import managers.ExtentManager;
import managers.ExtentTestManager;

public class BaseForJavaScript {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeSuite
	public void initialise() throws IOException {
		ExtentManager.initReport();
	}

	@BeforeMethod
	public void preReq(Method method) {

		ExtentTestManager.createTest(method.getName());
		String browser = "Chrome";
//		
//		if (browser.equals("Chrome")) {
//		
//		driver = new ChromeDriver();
//		}

		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			ExtentTestManager.log.info("Chrome Browser was launched succcessfully !!");
			break;

		case "Firefox":

			driver = new FirefoxDriver();
			ExtentTestManager.log.info("Firefox Browser was launched succcessfully !!");
			break;

		case "Edge":
			driver = new EdgeDriver();
			ExtentTestManager.log.info("Edge Browser was launched succcessfully !!");
			break;

		case "Safari":
			driver = new SafariDriver();
			ExtentTestManager.log.info("Safari Browser was launched succcessfully !!");
			break;

		case "InternetExplorerDriver":
			driver = new InternetExplorerDriver();
			ExtentTestManager.log.info("IE Browser was launched succcessfully !!");
			break;

		default:
			System.out.println("Browser not Supported !");
			ExtentTestManager.log.info("No Matching Browser was found  !!");
			break;

		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("https://the-internet.herokuapp.com/");
		ExtentTestManager.log.info("Navigated to the url");

	}

	@AfterMethod
	public void endTest() {

		driver.quit();
		//System.out.println("Browser is closed");
		ExtentTestManager.log.info("Browser window was closed succcessfully !!");

	}

	@AfterSuite
	public void tearDown() {
		ExtentManager.flushReport();
	}
}
