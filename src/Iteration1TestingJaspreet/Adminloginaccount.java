package Iteration1TestingJaspreet;

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

class Adminloginaccount {
    
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
     void adminloginwithemail() {
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/AdminHome"));

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "http://localhost:3000/AdminHome";
        assertEquals(expectedUrl, actualUrl, "Admin should be redirected to the Admin Dashboard after login.");
    }


    @Test
     void loginuseraccount() {
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/homeUser"));

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "http://localhost:3000/homeUser";
        assertEquals(expectedUrl, actualUrl, "User should be redirected to the User Dashboard after login.");
    }
    
    @Test
     void loginaccountwrongcredentails() {
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("jaspreeeet@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        
        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "http://localhost:3000/homeUser";
        assertEquals(expectedUrl, actualUrl, "User should be redirected to the User Dashboard after login.");
    }
    
    @Test
     void loginadminaccountwrongcredentails() {
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin123456");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        
        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "http://localhost:3000/homeUser";
        assertEquals(expectedUrl, actualUrl, "User should be redirected to the User Dashboard after login.");
    }

    
    @Test
    public void Adminhometitlecheck() {
               loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/AdminHome"));

       
        WebElement eventUpMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/h1"));
        assertTrue(eventUpMessage.isDisplayed(), "'Event UP' message should be displayed after login.");
    }


    @Test
     void Adminsignout() {
               loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/AdminHome"));
        
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/AdminHome"));

        WebElement adminsignout = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/button"));
        adminsignout.click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));  

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("http://localhost:3000/"), "User should be redirected to the homepage after deleting the account.");
    
    }

    
    @Test
     void userhometitlecheck() {
               loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/homeUser"));

       
        WebElement eventUpMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/h1"));
        assertTrue(eventUpMessage.isDisplayed(), "'Event UP' message should be displayed after login.");
    }
    
    
    @Test
     void DisplayAdminMessgae() {
       
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/AdminHome"));

        WebElement eventUpMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a"));
        assertTrue(eventUpMessage.isDisplayed(), "'admindashboard' message should be displayed after login.");
    }


    
    @Test
     void deleteAccountTest() {
        
        loadHomePage();

        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/homeUser"));

        WebElement profileLink = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]"));
        profileLink.click();

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/UserProfile"));

        WebElement deleteAccountButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/button"));
        deleteAccountButton.click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/UserProfile"));  // assuming the user is redirected to the homepage after deletion

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("http://localhost:3000/UserProfile"), "User should be redirected to the homepage after deleting the account.");
    }
    
    
    

    
    
    @Test
     void testLoginAfterAccountDeletion() {
        loadHomePage(); 

        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("jaspreet@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("123456");

        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/div")));  // Update XPath if necessary

        WebElement noUserFoundMessage = driver.findElement(By.xpath("/html/body/div/div/div/form/div"));  // Update XPath if necessary
        assertTrue(noUserFoundMessage.isDisplayed(), "'No user found' message should be displayed after login attempt with deleted account.");
    }
    
    
    @Test
     void testUserProfilePageDisplay() {
        driver.get("http://localhost:3000/Userprofile");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/p")));

        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/p"));
        assertTrue(element.isDisplayed(), "The element should be displayed on the UserProfile page.");
    }

    
    @Test
     void AdmincheckForgotPasswordLink() {
        driver.get("http://localhost:3000");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("/html/body/div/div/div/form/span"));

        assertTrue(forgotPasswordLink.isDisplayed(), "'Forgot Password' link should be visible.");
        assertTrue(forgotPasswordLink.isEnabled(), "'Forgot Password' link should be clickable.");
    }

             
    @Test
     void AdminresetPasswordLinkNavigation() {
        driver.get("http://localhost:3000");

        WebElement forgotPasswordLink = driver.findElement(By.xpath("/html/body/div/div/div/form/span"));
        forgotPasswordLink.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("http://localhost:3000/ForgotPassword"));  

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("http://localhost:3000/ForgotPassword"), "User should be redirected to the reset password page.");
    }

    
    @AfterEach
    void tearDown() {
        driver.quit();
    }
    

}
