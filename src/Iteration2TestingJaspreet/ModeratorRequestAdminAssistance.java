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
        
        driver = new ChromeDriver();
    }

   

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
    public void AdminRequestbyWritingPost() {
        loadHomePage();

        
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moderatorDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.className("moderator-dashboard")));
        moderatorDashboard.click();

       
        WebElement requestAdminAssistanceButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("requestAdminAssistanceButton")));
        requestAdminAssistanceButton.click();

        
        WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/textarea")));
        textarea.sendKeys("I am testing the assitance");

        
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        submitButton.click();

        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();  
            System.out.println("Alert accepted: Request submitted successfully!");
        } catch (Exception e) {
            System.out.println("No alert present or could not accept the alert.");
        }
    }
    
    @Test
    public void AdminRequestwithoutwritingpost() {
        loadHomePage();

        
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("moderator@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moderatorDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.className("moderator-dashboard")));
        moderatorDashboard.click();

        
        WebElement requestAdminAssistanceButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("requestAdminAssistanceButton")));
        requestAdminAssistanceButton.click();

       
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        submitButton.click();

       

        String actualValue = "please fill out this field";
        String expectedValue ="Give the reason for admin assitance";
        assertEquals(expectedValue, actualValue, "The text field is missing.");
    }
    
    @AfterEach
    void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
    }

}
