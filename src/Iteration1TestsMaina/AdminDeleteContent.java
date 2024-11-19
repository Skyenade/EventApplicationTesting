package Iteration1TestsMaina;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AdminDeleteContent {

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

		
	private void loadContentManagementPage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "admin@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "admin1234";
		passwordField.sendKeys(testPassword);
		
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminDash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[1]/h1/a")));
		adminDash.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement contentManagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/a")));
		contentManagement.click();
	}
	
	@Test
	void testAccessContentManagement() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "admin@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "admin1234";
		passwordField.sendKeys(testPassword);
		
		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminDash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[1]/h1/a")));
		adminDash.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement contentManagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/a")));
		contentManagement.click();
		
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/ContentManagement";
		
	    assertEquals(expectedUrl, url, "The URL should match the expected UserProfile page URL");

		
	}
		
	@Test
	void testRemoveButtonClickable() {
		loadContentManagementPage();
		
		WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/table/tbody/tr/td[6]/button[2]"));
		removeButton.click();
	}
		
	@Test
	void testCheckRemoveContent() {
	    loadContentManagementPage();

	    WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/table/tbody/tr/td[6]/button[2]"));
	    removeButton.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
	    
	    firstAlert.accept();

	    Alert secondAlert = wait.until(ExpectedConditions.alertIsPresent());
	    String alertMessage = secondAlert.getText();
	    System.out.println(alertMessage);
	    String expectedMessage = "Selected Content removed successfully.";
	    
	    assertEquals(alertMessage, expectedMessage);
	}
	
	@Test
	void testCheckRemoveContentSucessfull() {
	    loadContentManagementPage();

	    WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/table/tbody/tr/td[6]/button[2]"));
	    removeButton.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
	    String alertMessage = firstAlert.getText();
	    firstAlert.accept();

	    Alert secondAlert = wait.until(ExpectedConditions.alertIsPresent());
	    secondAlert.accept();
	}
	
}
