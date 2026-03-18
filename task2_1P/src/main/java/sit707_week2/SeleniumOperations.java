package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void spotify_registration_page(String url) {

	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");
	    
	    System.out.println("Fire up chrome browser.");
	    WebDriver driver = new ChromeDriver();

	    sleep(2);
	    driver.get(url);
	    sleep(3);

	    // enter email
	    WebElement element = driver.findElement(By.id("username"));
	    System.out.println("Found element: " + element);
	    element.sendKeys("akmcanda@gmail.com");

	    //then click Next button
	    driver.findElement(By.xpath("//span[text()='Next']")).click();

	    // take screenshot
	    sleep(3);
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File("spotify.png");

	    try {
	        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    sleep(2);
	    driver.close();
	}
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Akashya");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		driver.findElement(By.id("lastname")).sendKeys("Mann");
		driver.findElement(By.id("phoneNumber")).sendKeys("0412345678");
		driver.findElement(By.id("email")).sendKeys("akmcanda@gmail.com");
		driver.findElement(By.id("password")).sendKeys("000");
		driver.findElement(By.id("confirmPassword")).sendKeys("000");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		driver.findElement(By.xpath("//button[@data-testid='account-action-btn']")).click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		sleep(3);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("result.png");
		try {
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}