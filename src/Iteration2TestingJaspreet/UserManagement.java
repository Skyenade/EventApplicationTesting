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


import org.junit.jupiter.api.Test;

class UserManagement {

	WebDriver driver;

    @BeforeEach
    void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();  
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
    public void AdminViewUseraccount() {
        loadHomePage();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

      
        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        
        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));

        
        try {
            usermanagement.click();
        } catch (Exception e) {
        }}
    
    @Test
    public void ModeratorSuspendaccount() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement suspendaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/button[2]\r\n"
        		+ ""
        		+ "")));
        suspendaccount.click();

        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // Click "OK" on the alert
            System.out.println("Alert accepted: Request submitted successfully!");
        } catch (Exception e) {
            System.out.println("No alert present or could not accept the alert.");
        }}
    
    @Test
    public void ModeratorRestoreaccount() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement Restoreaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/button[4]\r\n"
        		+ "")));
        Restoreaccount.click();

    }
    

    
    @Test
    public void ModeratorDeleteaccount() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement deleteaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/button[3]\r\n"
        		+ "")));
        deleteaccount.click();

        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // Click "OK" on the alert
            System.out.println("Alert accepted: Request submitted successfully!");
        } catch (Exception e) {
            System.out.println("No alert present or could not accept the alert.");
        }}
    
    
    @Test
    public void Moderatoreditaccount() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement editaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[3]/td[4]/button[1]\r\n"
        		+ "")));
        editaccount.click();

       
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); 
            System.out.println("Alert accepted: Request submitted successfully!");
        } catch (Exception e) {
            System.out.println("No alert present or could not accept the alert.");
        }}

    
    @Test
    public void AssignModeratorRole() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement moderatorrole = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[4]/td[3]/input[2]\r\n"
        		+ ""
        		+ "")));
        moderatorrole.click();

    }
    
    
    @Test
    public void AssignUserRole() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

        WebElement admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[1]/h4/a")));
        admindashboard.click();

        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a")));
        usermanagement.click();

        WebElement userrole = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[4]/td[3]/input[1]\r\n"
        		+ "")));
        userrole.click();

    }

    
    
    
    
    
}
