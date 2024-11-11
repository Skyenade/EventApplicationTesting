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

class UserAddOrRemoveProfilePicture {

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
	void testDeletePictureClickable() {
		loadUserProfilePage();
		
		WebElement deletePictureButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/button"));
		deletePictureButton.click();
	}

	@Test
	void testDeletePicture() {
		loadUserProfilePage();
		
		WebElement deletePictureButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div/button"));
		deletePictureButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/button")));
	    saveButton.click();
		
		WebElement pictureAlt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/p"));
		String pictureText = pictureAlt.getText();
		
		String expectedText = "No profile picture set.";
		
		assertEquals(pictureText, expectedText);
	}
}