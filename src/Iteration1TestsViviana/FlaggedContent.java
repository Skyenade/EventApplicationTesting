package Iteration1TestsViviana;

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

class FlaggedContent {
	
	private WebDriver driver;

	  @BeforeEach
	    void setUp() {
	        // Initialize WebDriver before each test
	        driver = new ChromeDriver();
	    }


//    @AfterEach
//	void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//    }




//As an Admin , see flagged content in a report queue to view flagged content.
	
	private void AdminHome() {
		   driver.get("http://localhost:3000/Login");  // Update to use a file URI
		       
	    WebElement EmailInput = driver.findElement(By.id("signinEmail"));
	    EmailInput.sendKeys("admin@gmail.com");
	
	    WebElement PasswordInput = driver.findElement(By.id("signinPassword"));
	    PasswordInput.sendKeys("admin1234");
	    
	    WebElement btnlogin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button[1]"));
	    btnlogin.click();
	}
	
	//As an admin, I want to create new user accounts
	
	    @Test	
			 void ViewFlaggedContent()  {
			 		AdminHome();
				       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				       WebElement GotoAdminDashborardBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/aside/div[1]")));
				       GotoAdminDashborardBtn.click();
				       
				       WebElement GototheContentmanagementBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div/div[2]/a")));
				       GototheContentmanagementBtn.click();
				       
				     				        
				        String url = driver.getCurrentUrl();	    
				   	    String baseUrl = url.split("\\?")[0];	    
				   	    String expectedUrl = "http://localhost:3000/ContentManagement";
				   	    
				   	    assertEquals(expectedUrl, baseUrl);
				   	    
	    }}
