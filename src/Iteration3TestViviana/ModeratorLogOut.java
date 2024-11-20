package Iteration3TestViviana;

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

class ModeratorLogOut {

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
  
    private void SignOutBtn() {
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
    // As a moderator, log out to my account

		  		@Test	
				void LogOut()  {
		    	SignOutBtn();
    
					       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					       WebElement GotoLogOutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]")));
					       GotoLogOutBtn.click();
	       
					        String url = driver.getCurrentUrl();	    
					   	    String baseUrl = url.split("\\?")[0];	    
					   	    String expectedUrl = "http://localhost:3000/";
			   	   
					   	    assertEquals(expectedUrl, baseUrl);				   	    

}
		 
		 // The btn to log Out is visible    
		    
		   		 @Test
	    		 void testLogOutBtnIsVisible() {
	        	 SignOutBtn();
	    		
		    		WebElement LogOut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]"));
		    		Boolean LogOutDisplayed = LogOut.isDisplayed();
		    		assertTrue(LogOutDisplayed);

		    }    
		    
		 // The btn to log Out Is Clickable
		    
	    	@Test
	    	void testLogOutBtnIsClickable() {
	    		SignOutBtn();
	    		
	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	          
	            WebElement logOutBtn = wait.until(d -> d.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]")));
	            
	            // Verify that the button is visible and clickable
	            assertTrue(logOutBtn.isDisplayed(), "The 'Sign Out' button is not visible.");
	            assertTrue(logOutBtn.isEnabled(), "The 'Sign Out' button is not enabled.");	       
	            logOutBtn.click();

	            // Validate redirection to the main page
	            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
	            String currentUrl = driver.getCurrentUrl();
	            assertEquals("http://localhost:3000/", currentUrl, "Did not redirect correctly to the main page.");
	        }
	    

	    	}    
		    
