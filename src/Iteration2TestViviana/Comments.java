package Iteration2TestViviana;

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

class Comments {

	 private WebDriver driver;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	    }

//	    @AfterEach
//	    void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
//	    
	    private void userHome() {

	    	   driver.get("http://localhost:3000");  // Update to use a file URI

	    	   driver.get("http://localhost:3001");  // Update to use a file URI

	    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	   
	    	   	WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
	   			String testEmail = "user@gmail.com";
	   			inputField.sendKeys(testEmail);

		   		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
		   		String testPassword = "123456";
		   		passwordField.sendKeys(testPassword);
	
		   		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
		   		loginBtn.click();
		   		
		   	
	   }
	   
	   //As a user, I can post a comment on an event.

	           @Test	
				 void CreateComent()  {
	        	   		userHome();
					       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					       WebElement GotoCommentBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[2]/button[3]")));
					       GotoCommentBtn.click();
					       
					       WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/textarea"));
			   				String coment = "test case";
			   				inputField.sendKeys(coment);
					       
					       WebElement GotoPostBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/button")));
					       GotoPostBtn.click();
					       
					       					        
					        String url = driver.getCurrentUrl();	    
					   	    String baseUrl = url.split("\\?")[0];	    
					   	    String expectedUrl = "http://localhost:3001/homeUser";
					   	    
					   	    assertEquals(expectedUrl, baseUrl);
					   	    
	           }}