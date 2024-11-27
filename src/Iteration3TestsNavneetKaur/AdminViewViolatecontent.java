package Iteration3TestsNavneetKaur;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

class AdminViewViolatecontent {

	private WebDriver driver;
    WebDriverWait wait;
    
    private ReportService reportService;  
    private List<Report> reports;

	    @BeforeEach
	    public void setUp() {
	    	driver = new ChromeDriver();
	        driver.get("http://localhost:3000/AdminReports"); 
	        reportService = new ReportService();
	        
	        reports = reportService.getReports();

	    }

	    @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    @Test
	    public void testTITLE() {
	        WebElement path = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h1"));
	        String actualtext = "Reported Events and Comments";
	        String expectedText = path.getText();
	        assertEquals(expectedText, actualtext);
	    }
	    
	
	    @Test
	    public void testReportStorageVisibility() {
	        try {
	            WebElement table = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	            table.isDisplayed();
	            assertNotNull(table);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }}
	    
	    
	    
	    @Test
	    public void testReportType() {
	    try {
        	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
            Countainer.isDisplayed();
            String reportType = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[1]")).getText();
           assertEquals("event", reportType);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	    }
	    
	    
	    @Test
	    public void testContentID() {
	    	try {
	        	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	            Countainer.isDisplayed();
	            String reportType = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[2]")).getText();
	           assertSame("event", reportType);
	           
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    @Test
	    public void testContentDetails() {
	    	 try {
	         	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	            Countainer.isDisplayed();

	            String contentDetails = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[3]")).getText();
	            assertEquals("user@gmail.com", contentDetails);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }

	    @Test
	    public void testReportedBy() {
	    	 try {
	         	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	             assertTrue("Countainer should be visible.", Countainer.isDisplayed());	           

	            String reportedBy = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[4]")).getText();
	            assertNotSame("nav@gmail.com", reportedBy);

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("");
	        }
	    }

	    	    @Test
	    public void testReason() {
	    	    	try {
	    	        	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	    	            Countainer.isDisplayed();
	    	            String reportType = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[5]")).getText();
	    	           assertEquals("report", reportType);
	    	            
	    	        } catch (Exception e) {
	    	            System.out.println("Error during test: " + e.getMessage());
	    	            e.printStackTrace();
	    	        }
	    }

	    @Test
	    public void testStatus() {
	    	try {
	        	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	            assertTrue("Countainer should be visible.", Countainer.isDisplayed());
	            Thread.sleep(2000);
	            String reportType = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/p[6]")).getText();
	           assertEquals("pending", reportType);
	            
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testReportedOn_Date() {
	    	try {
	        	WebElement Countainer = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul"));
	            assertTrue("Countainer should be visible.", Countainer.isDisplayed());
	            Thread.sleep(2000);
	            String reportType = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[1]/small")).getText();
	           assertEquals("11/17/2024, 10:18:44 PM", reportType);
	            
	        } catch (Exception e) {
	            System.out.println("Error during test: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	}


	    
