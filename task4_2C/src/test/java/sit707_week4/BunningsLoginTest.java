package sit707_week4;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BunningsLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmca\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s224597443";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Akashya Mann";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testLoginPageLoads() {
        driver.get("https://www.bunnings.com.au/login");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testEmptyEmailAndPassword() throws InterruptedException {
        driver.get("https://www.bunnings.com.au/login");

        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']/ancestor::button"));
        signInButton.click();

        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testInvalidEmailAndPassword() throws InterruptedException {
        driver.get("https://www.bunnings.com.au/login");

        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']/ancestor::button"));

        emailField.sendKeys("wrong@email.com");
        passwordField.sendKeys("wrongpassword");
        signInButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testEmptyEmailValidPassword() throws InterruptedException {
        driver.get("https://www.bunnings.com.au/login");

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']/ancestor::button"));

        passwordField.sendKeys("Password123");
        signInButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }

    @Test
    public void testValidEmailEmptyPassword() throws InterruptedException {
        driver.get("https://www.bunnings.com.au/login");

        WebElement emailField = driver.findElement(By.id("username"));
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']/ancestor::button"));

        emailField.sendKeys("test@example.com");
        signInButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }
}