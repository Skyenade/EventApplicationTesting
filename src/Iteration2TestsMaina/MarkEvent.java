package Iteration2TestsMaina;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class MarkEvent {

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
	void testAttendEventCheckboxVisible() {
		loadEventDetailsPage();
		
		WebElement attend = driver.findElement(By.xpath("//*[@id=\"attendEvent\"]"));
		Boolean attendDisplayed = attend.isDisplayed();
		assertTrue(attendDisplayed);
	}
	
	@Test
	void testAttendEventCheckboxClickable() {
		loadEventDetailsPage();
		
		WebElement attend = driver.findElement(By.xpath("//*[@id=\"attendEvent\"]"));
		attend.click();
	}
	
	@Test
	void testAttendEventCheckboxIsChecked() {
		loadEventDetailsPage();
		
		WebElement attend = driver.findElement(By.xpath("//*[@id=\"attendEvent\"]"));
		attend.click();
		Boolean attendChecked = attend.isSelected();
		assertTrue(attendChecked);
	}
	
	@Test
	void testAttendEventCheckboxStaysChecked() {
	    loadEventDetailsPage();
	    
	    WebElement attend = driver.findElement(By.xpath("//*[@id=\"attendEvent\"]"));
	    attend.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    boolean attendChecked = wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//*[@id=\"attendEvent\"]"), true));
	    
	    assertTrue(attendChecked);	    
	}


}
