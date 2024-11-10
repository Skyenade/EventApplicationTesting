package Iteration1TestsNavneetKaur;

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
import org.openqa.selenium.support.ui.WebDriverWait;


class MyEvents {

	private WebDriver driver;
    WebDriverWait wait;
	 

	    @BeforeEach
	    public void setUp() {
	    	driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://localhost:3000/HomeUser"); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    }

	    @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

//	 @Test
//	    public void Feed_testText() {
//	        WebElement expectedTextPath = driver.findElement(By.xpath("/html/body/div[1]/div/div/h1"));
//	        String actualtext = "Event Feed";
//	        String expectedText = expectedTextPath.getText();
//	        assertEquals(expectedText, actualtext);
//	    }
//	 
	 

	    
	    @Test
	    public void DisplayEvent_Title() {
	        WebElement eventTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div/div[2]/h2"));
	        String expectedTitle = "Event1";
	        String actualTitle = eventTitle.getText();
	        assertTrue(actualTitle.contains(expectedTitle));
	    }
	    
	 
	 @Test
	 public void DisplayEvent_DateTime() {
	        WebElement eventDateElement = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div/div[1]/p[1]"));
	        String actualDate_Time = eventDateElement.getText();
	        String expectedDate_Time = "Date & Time: 11/7/2024, 11:16:00 AM";
	        assertEquals(expectedDate_Time, actualDate_Time, "The displayed date and time do not match the expected values.");
	    }
	    
	 @Test
	 public void TestDisplay_Image() {
    	WebElement event_Image = driver.findElement(By.xpath(""));
        String actualImage = event_Image.getText();
        String expectedImage = "";
        assertNotNull( actualImage.contains(expectedImage));
    }
	    
	    @Test
		 public void TestDisplay_Location() {
	    	WebElement event_Location = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div/div[1]/p[2]"));
	        String actualLocation = event_Location.getText();
	        String expectedLocation = "Location: Montreal, QC, Canada";
	        assertNotNull( actualLocation.contains(expectedLocation));
	    }
	    
	    @Test
		 public void TestDisplay_Detail() {
	    	WebElement event_Location = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div/div[2]/p[3]"));
	        String actualLocation = event_Location.getText();
	        String expectedLocation = "Details: this is a good event";
	        assertNotNull( actualLocation.contains(expectedLocation));
	    }
	    
	    
}
