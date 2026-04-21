package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.navigate().to(
				"file:///C:/Users/akmca/OneDrive/Desktop/7.1P-resources/pages/login.html");
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
		((JavascriptExecutor) driver).executeScript("arguments[0].value='2000-01-01';", ele);
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertEquals(title, "success");
		
		driver.close();
	}
	
	
	@Test
	public void testLoginFailWrongUsername() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(
				"file:///C:/Users/akmca/OneDrive/Desktop/7.1P-resources/pages/login.html");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wrong");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		ele = driver.findElement(By.id("dob"));
		((JavascriptExecutor) driver).executeScript("arguments[0].value='2000-01-01';", ele);
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "fail");
		
		driver.close();
	}
	
	
	@Test
	public void testLoginFailWrongPassword() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(
				"file:///C:/Users/akmca/OneDrive/Desktop/7.1P-resources/pages/login.html");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wrong_pass");
		
		ele = driver.findElement(By.id("dob"));
		((JavascriptExecutor) driver).executeScript("arguments[0].value='2000-01-01';", ele);
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "fail");
		
		driver.close();
	}

	@Test
	public void testLoginFailWrongDob() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to(
				"file:///C:/Users/akmca/OneDrive/Desktop/7.1P-resources/pages/login.html");
		sleep(5);
		
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		ele = driver.findElement(By.id("dob"));
		((JavascriptExecutor) driver).executeScript("arguments[0].value='1999-01-01';", ele);
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "fail");
		
		driver.close();
	}
}