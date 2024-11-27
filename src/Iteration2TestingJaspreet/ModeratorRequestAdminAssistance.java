package Iteration2TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModeratorRequestAdminAssistance {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

   

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
     void testRequestAdminAssistanceFlow() {
       
        driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

       
        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a\r\n"
        		+ "")); 
        dashboardLink.click();

       
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));

        
        WebElement requestAdminButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button"));
        requestAdminButton.click();

       
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/textarea")));
        assertTrue(textarea.isDisplayed(), "The text displayed visible.");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        assertTrue(submitButton.isDisplayed(), "The Submit button should be visible.");
    }
        
    
    @Test
     void testRequestAdminAssistanceByWritingPost() {
        driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

        
        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a")); 
        dashboardLink.click();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));

        
        WebElement requestAdminButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button"));
        requestAdminButton.click();

        
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/textarea")));
        textarea.sendKeys("jaspreet admin request submission.");

        
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        submitButton.click();

        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));
        assertEquals(driver.getCurrentUrl(), "http://localhost:3000/ModeratorDashboard", "modeartor dasboard.");
    }

    
    @Test
     void testNavigateToModeratorDashboard() {
        
    	driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

        
        WebElement moderatorDashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a"));
        moderatorDashboardLink.click();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));
        assertEquals(driver.getCurrentUrl(), "http://localhost:3000/ModeratorDashboard", "moderator dashboard");
    }
    
    @Test
     void testNavigateToRequestAdminAssistancePage() {
        
        driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

        
        WebElement moderatorDashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a"));
        moderatorDashboardLink.click();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));

       
        WebElement requestAdminAssistanceButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button"));
        requestAdminAssistanceButton.click();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/RequestAssistance"));
        assertEquals(driver.getCurrentUrl(), "http://localhost:3000/RequestAssistance", "The URL should be the Request Admin Assistance page.");
    }


    @Test
     void testSubmitButtonVisibility() {
        
        driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a\r\n"
        		+ "")); 
        dashboardLink.click();

       
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));

        
        WebElement requestAdminButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button"));
        requestAdminButton.click();

       
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/button")));
        assertTrue(submitButton.isDisplayed(), "The Submit button should be visible.");
    }

    @Test
     void testEmptyTextareaPreventsSubmission() {
      
        driver.get("http://localhost:3000");
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

       
        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a\r\n"
        		+ "")); 
        dashboardLink.click();

        
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorDashboard"));

        
        WebElement requestAdminButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button"));
        requestAdminButton.click();

        
        WebElement textarea = driver.findElement(By.xpath("/html/body/div/div/div/form/textarea"));

        
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        submitButton.click();

        
        String validationMessage = textarea.getAttribute("validationMessage");
        assertEquals("Please fill out this field.", validationMessage, "Validation message should indicate the field is required.");
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
    
         

}
