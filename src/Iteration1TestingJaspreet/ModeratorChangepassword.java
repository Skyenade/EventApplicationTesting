package Iteration1TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;

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

import dev.failsafe.internal.util.Assert;

import java.time.Duration;

class ModeratorChangepassword {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }
    
    

    @Test
    public void Entermoderatoremail() {
        driver.get("http://localhost:3000");

        driver.findElement(By.xpath("/html/body/div/div/div/form/span")).click();
        
        WebElement Enteremail = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input"));
        Enteremail.sendKeys("chahal.j95@gmail.com");

        driver.findElement(By.xpath("/html/body/div/div/div/div/form/button")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        
        alert.accept();  

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:3000/";  
        assertEquals(expectedUrl, actualUrl, "User should be redirected to the homepage after email reset.");
    }
    
    @Test
     void ResetButtonCheck() {
        driver.get("http://localhost:3000");

        driver.findElement(By.xpath("/html/body/div/div/div/form/span")).click();
        
        WebElement enterEmail = driver.findElement(By.xpath("/html/body/div/div/div/div/form/input"));
        enterEmail.sendKeys("");

        driver.findElement(By.xpath("/html/body/div/div/div/div/form/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.attributeToBeNotEmpty(enterEmail, "validationMessage"));

        String validationMessage = enterEmail.getAttribute("validationMessage");

        assertEquals("Please fill out this field.", validationMessage, "The validation message should be 'Please fill out this field.'");
    }

    
    @Test
     void checkForgotPasswordLink() {
        driver.get("http://localhost:3000");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("/html/body/div/div/div/form/span"));

        assertTrue(forgotPasswordLink.isDisplayed(), "'Forgot Password' link should be visible.");
        assertTrue(forgotPasswordLink.isEnabled(), "'Forgot Password' link should be clickable.");
    }

             
    @Test
     void resetPasswordLinkNavigation() {
        driver.get("http://localhost:3000");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("/html/body/div/div/div/form/span"));
        forgotPasswordLink.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/ForgotPassword"));  

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("http://localhost:3000/ForgotPassword"), "User should be redirected to the reset password page.");
    }
    
      
     
       
       @Test
        void ModeartorLoginAfterPasswordreset() {
           driver.get("http://localhost:3000");
           WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
           emailField.sendKeys("moderator@gmail.com");
           WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
           passwordField.sendKeys("123456");
           WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
           loginButton.click();

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.urlToBe("http://localhost:3000/ModeratorHome"));

           String currentUrl = driver.getCurrentUrl();
           assertNotEquals("The URL should be ModeratorHome after login", 
                               "http://localhost:3000/ModeratorHome", 
                               currentUrl);
       }
       @AfterEach
       void tearDown() {
           driver.quit();
       }
   

    
   }
