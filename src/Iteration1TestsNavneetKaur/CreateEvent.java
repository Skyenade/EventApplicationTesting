ùpackage Iteration1TestsNavneetKaur;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;


class CreateEvent {

	private WebDriver driver;
    private WebDriverWait wait;
	 

	    @BeforeEach
	    public void setUp() {
	    	driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://localhost:3000/CreateEvent"); 
	    }

	    @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    @Test
	    public void testText() {
	        WebElement path = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/h1"));
	        String actualtext = "Create Event";
	        String expectedText = path.getText();
	        assertEquals(expectedText, actualtext);
	    }
	    

	    
	    @Test
	    public void Give_Title() {
	    	WebElement EventTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[1]"));
	    	EventTitle.clear();
	    	EventTitle.sendKeys("Innovation Fest");
	        assertNotNull(EventTitle);
	    }
	    
	    @Test
	    public void Provide_date() {
	    	WebElement EventDate = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[2]"));
	    	EventDate.clear();
	    	EventDate.sendKeys("2024-12-28");
	      assertNotNull(EventDate);
	    }
	    
	    
	    @Test
	    void testUploadFile() {
	        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file']")));
	        assertTrue(fileInput.isDisplayed(), "File input should be displayed");
	        String filePath = "/Users/navneetkamboj/Downloads/evnt.webp"; 
	        fileInput.sendKeys(filePath);
	        assertTrue(fileInput.getAttribute("value").contains("evnt.webp"), "File should be selected in the file input.");
	    }
	    
	    
	    @Test
	    void testSelectLocation() {
	        WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/input")));
	        assertTrue(locationInput.isDisplayed(), "Location input should be displayed");
	        String testLocation = "Laval";
	        locationInput.sendKeys(testLocation);
	        assertEquals(testLocation, locationInput.getAttribute("value"));
	    }
	    
	    
	    @Test
	    void testEventDetailsInput() {
	        WebElement eventDetailsTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[3]/textarea")));
	        assertTrue(eventDetailsTextarea.isDisplayed(), "Event details textarea should be displayed");
	        String testDetails = "This event is different.";
	        eventDetailsTextarea.sendKeys(testDetails);
	        assertEquals(testDetails, eventDetailsTextarea.getAttribute("value"));
	    }


	    @Test
	    void testCreateEventButtonIsClickable() {
	        WebElement createEventButton = driver.findElement(By.xpath("//button[@class='create-event-button' and text()='Create Event']"));
	        assertTrue(createEventButton.isEnabled(), "Create Event button should be enabled");
	        assertTrue(createEventButton.isDisplayed(), "Create Event button should be displayed");
	        String buttonState = createEventButton.getAttribute("disabled");
	        assertNull(buttonState);
	        createEventButton.click();
	    }

	    @Test
	    void testCreateEventWithAllDetails() {
	    	
		    	WebElement EventTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[1]"));
		    	EventTitle.clear();
		    	EventTitle.sendKeys("Innovation Fest");

		        
		    	WebElement EventDate = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input[2]"));
		    	EventDate.clear();
		    	EventDate.sendKeys("2024-12-28, 05:04 PM");

		      
		        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file']")));
		        assertTrue(fileInput.isDisplayed(), "File input should be displayed");
		        String filePath = "/Users/navneetkamboj/Downloads/evnt.webp"; 
		        fileInput.sendKeys(filePath);

		        
		        WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/input")));
		        assertTrue(locationInput.isDisplayed(), "Location input should be displayed");
		        String testLocation = "Laval";
		        locationInput.sendKeys(testLocation);
		   
		        
		        WebElement eventDetailsTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[3]/textarea")));
		        assertTrue(eventDetailsTextarea.isDisplayed(), "Event details textarea should be displayed");
		        String testDetails = "This event is different.";
		        eventDetailsTextarea.sendKeys(testDetails);
	
		        WebElement createEventButton = driver.findElement(By.xpath("//button[@class='create-event-button' and text()='Create Event']"));
		        assertTrue(createEventButton.isEnabled(), "Create Event button should be enabled");
		        assertTrue(createEventButton.isDisplayed(), "Create Event button should be displayed");
		        String buttonState = createEventButton.getAttribute("disabled");
		        assertTrue(createEventButton.isEnabled());
		        createEventButton.click();
	    }








	    
}
