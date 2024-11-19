package Integration3TestsMaina;

import static org.junit.jupiter.api.Assertions.*;

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

class ModeratorSignOut {

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

		
	private void loadHomePage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "moderator@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();		
	}
	
	@Test
	void testAccessModeratorHomePage() {
		loadHomePage();
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/ModeratorHome";
		
		assertEquals(expectedUrl, expectedUrl);		
	}
	
	@Test
	void testSignOutButtonVisible() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]")));
		
		Boolean buttonDisplayed = signOutButton.isDisplayed();
		
		assertTrue(buttonDisplayed);
	}
	
	@Test
	void testSignOutButtonClickable() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]")));
		Boolean buttonDisplayed = signOutButton.isEnabled();;
		
		assertTrue(buttonDisplayed);
	}
	
	@Test
	void testSignOutButton() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]")));

		signOutButton.click();
		
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/";
		
		assertEquals(expectedUrl, expectedUrl);	
	}

}
