package Iteration3TestsNavneetKaur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class ContentManagement {

	private WebDriver driver;
    private WebDriverWait wait;
	 

	    @BeforeEach
	    public void setUp() {
	    	driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://localhost:3000/ContentManagement"); 
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
	    	 String actualtext = "Content Management";
		        String expectedText = EventTitle.getText();
		        assertEquals(expectedText, actualtext);
	    }
	    
	    
	    @Test
	    public void testTableVisibility() {
	        try {
	            WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table"));
	            assertTrue("Table should be visible.", table.isDisplayed());
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    
	    @Test
	    public void testWarningButton() {
	        try {
	        	WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table"));
	            assertTrue("Table should be visible.", table.isDisplayed());
	            WebElement warningButton = driver.findElement(By.id("Warning"));
                assertTrue(warningButton.isDisplayed());
	            
	            
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testDismissButtonVisibility() {
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://localhost:3000/AdminReports");

	        try {
	        	WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table"));
	            assertTrue("Table should be visible.", table.isDisplayed());

	                WebElement dismissButton = driver.findElement(By.id("Dismiss"));
	                assertTrue(dismissButton.isDisplayed());
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	            fail("Test failed due to exception.");
	        } finally {
	            driver.quit();
	        }
	    }

	    @Test
	    public void testRemoveButton() {
        try {
            WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table"));
            assertTrue("Table should be visible.", table.isDisplayed());

                WebElement removeButton = driver.findElement(By.id("Remove"));
                assertTrue(removeButton.isDisplayed(), "'Remove User' button should be visible.");
            
            
        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        }
    }


	    @Test
	    public void testWarningButton_Confirm() {
	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody")));
	            
	            List<WebElement> rows = driver.findElements(By.cssSelector("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]"));
	            
	            if (rows.isEmpty()) {
	                WebElement noReportsMessage = driver.findElement(By.id("Warning"));
	                assertNotNull(noReportsMessage.isDisplayed());
	                return;
	            }
	            
	            WebElement firstRow = rows.get(0);
	            WebElement warningButton = firstRow.findElement(By.id("Warning"));
	            
	            String buttonText = warningButton.getText();
	            assertEquals("Issue Warning", buttonText);
	            
	            warningButton.click();
	            
	            WebElement updatedButton = firstRow.findElement(By.id("Warning"));
	            String updatedButtonText = updatedButton.getText();
	            assertEquals( updatedButtonText, "'Remove Warning' button should be displayed after issuing the warning.");
	            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]/td[7]/button[2]")).click();
	            Alert confirmAlert = driver.switchTo().alert();
	            String txtConfirmAlert = confirmAlert.getText();
		        assertEquals("Issue a warning to this user? ", txtConfirmAlert); 
		        confirmAlert.dismiss();//	            
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    
	    }
	    
	    
	    @Test
	    public void testRemoveButton_Confirm() {
	        try {
	            
	            List<WebElement> rows = driver.findElements(By.cssSelector("/html/body/div/div/div/div[2]/div/table/tbody/tr[1]"));
	            
	            if (rows.isEmpty()) {
	                WebElement noReportsMessage = driver.findElement(By.id("Remove"));
	                assertNotNull(noReportsMessage.isDisplayed()); 
	                return;
	            }
	            
	            WebElement firstRow = rows.get(0);
	            WebElement Remove = firstRow.findElement(By.id("Remove"));
	            
	            Alert confirmAlert = driver.switchTo().alert();
	            assertNotEquals("Incorrect alert message", confirmAlert.getText()); 
	            
	            Remove.click();
	            
	            WebElement updatedButton = firstRow.findElement(By.id("Warning"));
	            String updatedButtonText = updatedButton.getText();
	            
	            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/table/tbody/tr[2]/td[7]/button[4]")).click();
	            
	            String txtConfirmAlert = confirmAlert.getText();
	            assertNull(txtConfirmAlert); 
	            
	            confirmAlert.dismiss();
	            
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }



	    
	    
}
