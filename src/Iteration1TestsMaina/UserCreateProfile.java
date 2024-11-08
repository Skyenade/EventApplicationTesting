package Iteration1TestsMaina;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

	@Test
	void testAcessCreateProfilePage() {
		driver.get("http://localhost:3000/");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button[1]"));
		loginBtn.click();
		WebElement inputField = driver.findElement(By.id("signinEmail"));
		String testEmail = "mainaaa.16@gmail.com";
		inputField.sendKeys(testEmail);

		WebElement passwordField = driver.findElement(By.id("signinPassword"));
		String testPassword = "123456";
		passwordField.sendKeys(testPassword);

		WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button"));
		submitBtn.click();
	}

}
