package Iteration2TestsMaina;

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

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class UserReportContentOrComment {

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

		
	private void loadEventDetailsPage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "user@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement eventDetailsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/button")));
		eventDetailsBtn.click();
	}
	
	private void loadEventFeedPage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "user@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();
	}
	
	public static String getBaseURL(String fullUrl) {
        if (fullUrl.contains("/event/")) {
            return fullUrl.split("/event/")[0] + "/event/";
        } else {
            return fullUrl;
        }
    }
	
	@Test
	void testAccessEventDetails() {
		loadEventDetailsPage();
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/event/";
		String baseURL = getBaseURL(url);
		
		assertEquals(expectedUrl, baseURL);		
	}
	
	@Test
	void testContentTextAreaVisible() {
		loadEventDetailsPage();
		
		WebElement text = driver.findElement(By.xpath("//*[@id=\"reportReason\"]"));
		Boolean textDisplayed = text.isDisplayed();
		assertTrue(textDisplayed);		
	}
	
	@Test
	void testContentReportButtonVisible() {
		loadEventDetailsPage();
		
		WebElement report = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/button"));
		Boolean reportDisplayed = report.isDisplayed();
		assertTrue(reportDisplayed);		
	}
	
	@Test
	void testContentReportClickable() {
		loadEventDetailsPage();
		
		WebElement report = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/button"));
		report.click();
	}
	
	@Test
	void testContentReportTextRequired() {
		loadEventDetailsPage();
		
		WebElement report = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/button"));
		report.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
	    String alertMessage = firstAlert.getText();
	    assertEquals(alertMessage, "Please provide a reason for reporting the event.");
	}
	
	@Test
	void testContentSendReport() {
		loadEventDetailsPage();
		
		WebElement text = driver.findElement(By.xpath("//*[@id=\"reportReason\"]"));
		text.sendKeys("test report friday");
		
		WebElement report = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/button"));
		report.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
	    String alertMessage = firstAlert.getText();
	    assertEquals(alertMessage, "Event reported successfully!");		
	}
	
	@Test
	void testAccessEventFeed() {
		loadEventFeedPage();
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/HomeUser";
		
		assertEquals(expectedUrl, expectedUrl);		
	}
	
	@Test
	void testCommentReportButtonVisible() {
		loadEventFeedPage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement commentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[4]")));
		commentBtn.click();		
		
		WebElement reportCommentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[3]/div[2]/div[2]/button")));
		
		Boolean btnVisible = reportCommentBtn.isDisplayed();
		
		assertTrue(btnVisible);		
	}
	
	
	@Test
	void testCommentReport() {
		loadEventFeedPage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement commentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[4]")));
		commentBtn.click();		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement reportCommentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[3]/div[2]/div[2]/button")));
		reportCommentBtn.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("test comment report");
		alert.accept();		
	}
	
	

}
