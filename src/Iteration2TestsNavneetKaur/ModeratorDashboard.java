package Iteration2TestsNavneetKaur;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModeratorDashboard {

    private WebDriver driver;
    private WebDriverWait wait;  

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize WebDriverWait
        driver.get("http://localhost:3000/ModeratorDashboard");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void Give_Title() {
    	WebElement EventTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/h1"));
    	 String actualtext = "Moderator Dashboard";
	        String expectedText = EventTitle.getText();
	        assertEquals(expectedText, actualtext);
    }
    
    
    @Test
    void testRequestButton() {
        WebElement Request_Button = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/button"));
        assertTrue(Request_Button.isEnabled(), "Create Event button should be enabled");
        assertTrue(Request_Button.isDisplayed(), "Create Event button should be displayed");
        String buttonState = Request_Button.getAttribute("disabled");
        assertNull(buttonState);
        Request_Button.click();

       
    }
    
   
    @Test
    public void testFLagContentTable_Visibility() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/table")));
            WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table"));
            assertTrue("Table should be visible.", table.isDisplayed());
        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testSuspendButton() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody")));
            List<WebElement> rows = driver.findElements(By.cssSelector("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]"));
            if (rows.isEmpty()) {
                WebElement noReportsMessage = driver.findElement(By.xpath("//p[text()='No flagged reports at the moment.']"));
                assertNotNull("No reports message should be displayed.", noReportsMessage.isDisplayed());
                return;
            }
            WebElement firstRow = rows.get(0);
            WebElement suspendButton = firstRow.findElement(By.id("Suspend"));
            suspendButton.click();
            WebElement status = driver.findElement(By.id("statusAfterSuspend"));
            assertTrue("Status should be updated after suspend action.", status.isDisplayed());
            
        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    @Test
    public void testUserSespension() {
        try {
        	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody")));
            List<WebElement> rows = driver.findElements(By.cssSelector("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]"));

            if (rows.isEmpty()) {
                WebElement noReportsMessage = driver.findElement(By.xpath("//p[text()='No flagged reports at the moment.']"));
                assertNotNull("", noReportsMessage.isDisplayed());
                return;
            }
            
            WebElement firstRow = rows.get(0);
            WebElement suspendButton = firstRow.findElement(By.id("Suspend"));
            suspendButton.click();
            WebElement status = driver.findElement(By.id("Suspend"));
            assertNull(status);
            

        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Test
    public void testWarningButtonClick() {
        try {
        	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody")));
            List<WebElement> rows = driver.findElements(By.cssSelector("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]"));
            
            if (rows.isEmpty()) {
                WebElement noReportsMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]/td[7]/button[2]"));
                String expectedText = "Warning";
                assertTrue( "",noReportsMessage.isDisplayed());
                return;
                
            }
            WebElement firstRow = rows.get(0);
            WebElement warningButton = firstRow.findElement(By.id("Warning"));
            assertSame(warningButton,firstRow);
        
        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
            e.printStackTrace();
        }
    }

    


}






