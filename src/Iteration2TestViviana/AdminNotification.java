package Iteration2TestViviana;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AdminNotification {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
	}

	   @AfterEach
//	    void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
	//    
	    private void AdminHome() {
	    	   driver.get("http://localhost:3001");  // Update to use a file URI
	    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	   
	    	   	WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
	   			String testEmail = "admin@gmail.com";
	   			inputField.sendKeys(testEmail);

		   		WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
		   		String testPassword = "1234";
		   		passwordField.sendKeys(testPassword);

		   		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
		   		loginBtn.click();
		   		
		   	
	   }
	   
	   //As an Admin,  receive notifications for critical platform events like flagged content and assistance requests from the moderator

	           @Test	
				 void AdminNot()  {
	        	   AdminHome();
					       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					       WebElement GotoviewednotificationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[2]/ul/li/button")));
					       GotoviewednotificationBtn.click();
					       					    		       
					       					        
					        String url = driver.getCurrentUrl();	    
					   	    String baseUrl = url.split("\\?")[0];	    
					   	    String expectedUrl = "http://localhost:3001/AdminAssistanceRequests";
					   	    
					   	    assertEquals(expectedUrl, baseUrl);
					   	    
	           }}