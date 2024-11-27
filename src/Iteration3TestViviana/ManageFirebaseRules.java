package Iteration3TestViviana;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageFirebaseRules {

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
			  
	 private void loginFirebase() {
	        driver.get("https://console.firebase.google.com/u/0/project/communityapplication-14c16"); // 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 }
	        @Test	
			 void FirestoreDataBase()  {
	        	loginFirebase();
	        	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement goToFirestoreDataBaseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-drop-list-0\"]/fire-navbar-item[1]/a/div[2]")));
	        goToFirestoreDataBaseBtn.click();

	        WebElement goToRulesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*[@id=\"mat-tab-link-23\"]/span[2]/span[2]")));
	        goToRulesBtn.click(); 
	        
	      
		      String url = driver.getCurrentUrl();	    
		   	    String baseUrl = url.split("\\?")[0];	    
		   	    String expectedUrl = "https://console.firebase.google.com/u/0/project/communityapplication-14c16/firestore/databases/-default-/data/~2Fcomments~2F2ZtftjqPSjO0l1G4H9m6";
  
		   	   
		   	    assertEquals(expectedUrl, baseUrl);	
		    
		    
	 }
	        @Test	
			 void RealTime()  {
	        	loginFirebase();
	        	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		    WebElement goToRealTimeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-drop-list-0\"]/fire-navbar-item[6]/a/div[2]")));
		    goToRealTimeBtn.click();
		    
		    WebElement goToRealtimeRulesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*[@id=\"mat-tab-link-29\"]/span[2]/span[2]")));
		    goToRealtimeRulesBtn.click();
		    
		  
		    String url = driver.getCurrentUrl();	    
	   	    String baseUrl = url.split("\\?")[0];	    
	   	    String expectedUrl = "https://console.firebase.google.com/u/0/project/communityapplication-14c16/database/communityapplication-14c16-default-rtdb/data";

	   	    assertEquals(expectedUrl, baseUrl);	
	   	    
	        }
	        
}


