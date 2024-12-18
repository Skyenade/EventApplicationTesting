package Iteration1TestsMaina;

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

class UserCreateProfile {

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

	private void loadUserProfilePage() {
		driver.get("http://localhost:3000/");

		driver.manage().window().maximize();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "mainaaa.16@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement userProfileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("userprofile-button")));
		userProfileBtn.click();
	}

	@Test
	void testAcessCreateProfilePage() {
		driver.get("http://localhost:3000/");
		
		driver.manage().window().maximize();
		
		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
		String testEmail = "mainaaa.16@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		submitBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement userProfileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("userprofile-button")));
		userProfileBtn.click();
		
		String url = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:3000/UserProfile";
		
	    assertEquals(expectedUrl, url, "The URL should match the expected UserProfile page URL");
	}
	
	@Test
	void testUserNameVisible() {
		loadUserProfilePage();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/h1"));
		Boolean findUsername = username.isDisplayed();
		assertTrue(findUsername);
	}
	
	@Test
	void testEmailVisible() {
		loadUserProfilePage();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/p[1]"));
		Boolean findEmail = email.isDisplayed();
		assertTrue(findEmail);
	}
	
	@Test
	void testBioVisible() {
		loadUserProfilePage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement bio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/textarea")));
		Boolean findBio = bio.isDisplayed();
		assertTrue(findBio);
	}

	@Test
	void testPreviousEventsVisible() {
		loadUserProfilePage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement events = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/ul")));
		Boolean findEvents = events.isDisplayed();
		assertTrue(findEvents);
	}

	@Test
	void testChooseFileVisible() {
		loadUserProfilePage();
		WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/label"));
		Boolean findChooseFile = chooseFile.isDisplayed();
		assertTrue(findChooseFile);
	}
	
	@Test
	void testDeletePictureVisible() {
		loadUserProfilePage();
		WebElement deletePicture = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/button"));
		Boolean findDeletePicture = deletePicture.isDisplayed();
		assertTrue(findDeletePicture);
	}
	
	@Test
	void testDeleteAccountVisible() {
		loadUserProfilePage();
		WebElement deleteAccount = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/button"));
		Boolean findDeleteAccount = deleteAccount.isDisplayed();
		assertTrue(findDeleteAccount);
	}
	
	@Test
	void testSaveButtonClickable() {
		loadUserProfilePage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/button")));
		saveButton.click();
	}
	
	@Test
	void testSavebioChanges() {
	    loadUserProfilePage();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement bio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/textarea")));
	    String bioText = bio.getText();
	    
	    bio.sendKeys("new bio");
	    
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/button")));
	    saveButton.click();
	    
	    driver.navigate().refresh();
	    	    
	    WebElement updatedBio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/textarea")));
	    String updatedBioText = updatedBio.getText();
	    
	    assertNotEquals(bioText, updatedBioText, "Bio text should be updated after saving changes");
	}

}
