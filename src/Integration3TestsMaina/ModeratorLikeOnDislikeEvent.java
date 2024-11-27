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

class ModeratorLikeOnDislikeEvent {

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
	void testLikeButtonDisplayed() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[1]")));
		
		Boolean buttonDisplayed = likeButton.isDisplayed();
		
		assertTrue(buttonDisplayed);	
	}
	
	@Test
	void testDislikeButtonDisplayed() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[2]")));
		
		Boolean buttonDisplayed = dislikeButton.isDisplayed();
		
		assertTrue(buttonDisplayed);	
	}
	
	@Test
	void testLikeButtonEnabled() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[1]")));
		
		Boolean buttonEnabled = likeButton.isEnabled();
		
		assertTrue(buttonEnabled);	
	}
	
	@Test
	void testDislikeButtonEnabled() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[2]")));
		
		Boolean buttonEnabled = dislikeButton.isEnabled();
		
		assertTrue(buttonEnabled);	
	}
	
	@Test
	void testLikeButtonText() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[1]")));
		
		String actualText = likeButton.getText();
		
		String expectedText = "Like";
		
		assertEquals(expectedText, actualText);
	}
	
	@Test
	void testdislikeButtonText() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[2]")));
		
		String actualText = dislikeButton.getText();
		
		String expectedText = "Dislike";
		
		assertEquals(expectedText, actualText);
	}

	@Test
	void testLikeButtonCount() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		WebElement likeCount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[1]/p[1]")));
		String likeCountBefore = likeCount.getText();
		System.out.println(likeCountBefore);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[2]/div[2]/button[1]")));
		likeButton.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String likeCountAfter = likeCount.getText();	
		System.out.println(likeCountAfter);
		
		assertEquals(likeCountBefore, likeCountAfter);
	}
	
	@Test
	void testDislikeButtonCount() {
		loadHomePage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		WebElement dislikeCount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[2]/div[1]/p[2]")));
		String dislikeCountBefore = dislikeCount.getText();
		System.out.println(dislikeCountBefore);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[2]")));
		dislikeButton.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String dislikeCountAfter = dislikeCount.getText();	
		System.out.println(dislikeCountAfter);
		
		assertEquals(dislikeCountBefore, dislikeCountAfter);
	}

}
