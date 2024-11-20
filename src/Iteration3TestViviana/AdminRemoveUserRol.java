package Iteration3TestViviana;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AdminRemoveUserRol {

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
			  
	 private void loginAsAdmin() {
	        driver.get("http://localhost:3000"); // 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	       
	        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
	        inputField.sendKeys("admin@gmail.com");

	     
	        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]"));
	        passwordField.sendKeys("admin1234");

	        
	        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]"));
	        loginBtn.click();
	    }
	 
	 @Test
	 void RemoveUserRol() {
		    loginAsAdmin(); // 

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement goToAdminDashBoardBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[1]/h4/a")));
		    goToAdminDashBoardBtn.click();

		    WebElement goToUserManagementBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/a")));
		    goToUserManagementBtn.click();
		    
		    WebElement goToRadiotBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[5]/td[3]")));
		    goToRadiotBtn.click();
		    
		    WebElement goToEditProfileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[5]/td[4]/button[1]")));
		    goToEditProfileBtn.click();
		    
		    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[5]/td[4]/button")));
            saveBtn.click();
            
//             Handling the confirmation alert message
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText(); // Get the alert text
            assertEquals("User updated successfully!", alertText, "Confirmation message does not match.");
            alert.accept(); // Accept the alert

            // Validate that you were directed to the user list after saving
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/UserManagement"));
            String currentUrl = driver.getCurrentUrl();
            assertEquals("http://localhost:3000/UserManagement", currentUrl, "Not redirected to user management page after saving.");
		    
		    
	 }
	 
}