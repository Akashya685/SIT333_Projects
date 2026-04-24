package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		//
		driver.navigate().to("http://localhost:8080/login");
		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		// Find dob element
		//
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("2000-01-01");
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
		
		driver.close();
	}
	
	
	@Test
	public void testLoginFailWrongUsername() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://localhost:8080/login");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wrong");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("2000-01-01");
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Incorrect credentials."));
		
		driver.close();
	}
	
	
	@Test
	public void testLoginFailWrongPassword() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://localhost:8080/login");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wrong_pass");
		
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("2000-01-01");
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Incorrect credentials."));
		
		driver.close();
	}

	@Test
	public void testQ1WrongAnswer() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://localhost:8080/login");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("2000-01-01");
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		ele = driver.findElement(By.id("number1"));
		ele.clear();
		ele.sendKeys("1");
		
		ele = driver.findElement(By.id("number2"));
		ele.clear();
		ele.sendKeys("2");
		
		ele = driver.findElement(By.id("result"));
		ele.clear();
		ele.sendKeys("0");
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String page = driver.getPageSource();
		Assert.assertTrue(page.contains("Wrong answer, try again."));
		
		driver.close();
	}
}