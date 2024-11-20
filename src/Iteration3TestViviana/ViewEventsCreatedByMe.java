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

class ViewEventsCreatedByMe {

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
	  
	    private void MyEvents() {
	    	   driver.get("http://localhost:3000");  // Update to use a file URI
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
	    // As a user, I can view events which are created by me.

			    @Test	
					 void ViewMyEvents()  {
			    			MyEvents();
						       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						       WebElement GotoMyEventsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[1]/a[2]")));
						       GotoMyEventsBtn.click();
						       
						     				       
						       WebElement GotoEventDetailsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul/li/button")));
						       GotoEventDetailsBtn.click();
						       
						       					        
						        String url = driver.getCurrentUrl();	    
						   	    String baseUrl = url.split("\\?")[0];	    
						   	    String expectedUrl = "http://localhost:3000/event/IkwADqjZlenM2pxb0Ejz";
//						   	    /events/aweQEUeQfENz0h1Rlpw0 Id from firestore database, we have to check the url in the browser if this is running properlly  
						   	   
						   	    assertEquals(expectedUrl, baseUrl);				   	    
        }
                   
		//Is the btn My Events visible?
       
                
			        @Test
			    	void testMyEventsBtnIsVisible() {
			        	MyEvents();
			    		
			    		WebElement Event = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]"));
			    		Boolean EventDisplayed = Event.isDisplayed();
			    		assertTrue(EventDisplayed);
    	}
    	
		// Events Btn Is Clickable
	    
		    	@Test
		    	void testMyEventsBtnIsClickable() {
		    		MyEvents();
		    		
		    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	    WebElement myEventsLink = wait.until(d -> d.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/a[2]")));
		    	    
		    	    // Verify that the link is visible and clickable
		    	    assertTrue(myEventsLink.isDisplayed(), " 'My Events btn' link is not visible.");
		    	    assertTrue(myEventsLink.isEnabled(), " 'My Events btn' link is not enabled.");

		    	  
		    	    myEventsLink.click();

		    	    // Verify the result (for example, that the expected page or content is displayed)
		    	    WebElement eventsSection = wait.until(d -> d.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]")));
		    	    assertTrue(eventsSection.isDisplayed(), "Events section not showing after clicking.");
		    	}
	

    	// User can go to  crate an event  
			    	@Test
			    	void UserCanCreateAnEvent() {
			    		MyEvents();
			    		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    		  WebElement GotoCreateAneEventBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/button[2]")));
			    		  GotoCreateAneEventBtn.click();
					       
					    				        
					        String url = driver.getCurrentUrl();	    
					   	    String baseUrl = url.split("\\?")[0];	    
					   	    String expectedUrl = "http://localhost:3000/CreateEvent";
					   	    
					   	    assertEquals(expectedUrl, baseUrl);				   	    
    	}
    }

    		









