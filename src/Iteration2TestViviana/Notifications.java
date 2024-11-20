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

class Notifications {

	private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//    
    private void ModeratorHome() {
    	   driver.get("http://localhost:3000");  // Update to use a file URI
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   
    	   	WebElement inputField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]"));
   			String testEmail = "moderator@gmail.com";
   			inputField.sendKeys(testEmail);

	   		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
	   		String testPassword = "123456";
	   		passwordField.sendKeys(testPassword);

	   		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
	   		loginBtn.click();
	   		
	   	
   }
   
   //As a moderator receives notifications related to flagged content I’m responsible for moderating.

           @Test	
			 void ViewNotifications()  {
        	   ModeratorHome();
				       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				       WebElement GotoviewednotificationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[2]/ul/li/button")));
				       GotoviewednotificationBtn.click();
				       
				    		       
				       					        
				        String url = driver.getCurrentUrl();	    
				   	    String baseUrl = url.split("\\?")[0];	    
				   	    String expectedUrl = "http://localhost:3001/ModeratorDashboard";
				   	    
				   	    assertEquals(expectedUrl, baseUrl);
				   	    
           }}