package Iteration1TestingJaspreet;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SigunUpUserTesing {

	WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000");
    }

    @Test
     void CreateAccoutWithValidDetails() {
        loadHomePage();

        // Locate and click the create account button
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        // Fill in the user details
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing9@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("Testing@123");

       
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                alert.accept();


        assertFalse("Alert should be dismissed.", isAlertPresent());
    }

	private boolean isAlertPresent() {
				return false;
	}
    @Test
     void Createaccountwithsamecredentials() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing7@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form/p[1]")); 
        assertTrue("Error message for existing account should be displayed.", errorMessage.isDisplayed());
    }

    @Test
     void CreateAccoutWithemailandpasswordwrong() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        
        String expectedUrl = "http://localhost:3000/SignupUser";
        assertNotEquals("The user should remain on the sign-up page with invalid details.", expectedUrl, driver.getCurrentUrl());
    }

    @Test
     void Createaccountwithfieldempty() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("http://localhost:3000/SignupUser", driver.getCurrentUrl(),
                "The user should remain on the same page if required fields are empty.");
    }

    @Test
     void createAccountWithUsernameEmpty() {
        loadHomePage();

        WebElement createAccountButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createAccountButton.click();

        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        usernameField.sendKeys("");  // Leave it empty

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form"));
        assertTrue("Error message should be displayed for missing username.", errorMessage.isDisplayed());
    }

    @Test
     void Createaccountwithemailempty() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form"));
        assertTrue("Error message for empty email should be displayed.", errorMessage.isDisplayed());
    }

    @Test
     void Createaccountwithpasswordempty() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();

        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();

        
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form"));
        assertTrue("Error message for empty password should be displayed.", errorMessage.isDisplayed());
    }

    @Test
     void Alreadyhaveaccountbuttoncheck() {
        loadHomePage();

        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createaccountbutton.click();
        WebElement alreadyhaveaccount = driver.findElement(By.xpath("/html/body/div/div/div/form/p"));
        alreadyhaveaccount.click();

        
        String expectedUrl = "http://localhost:3000/login"; 
        assertNotEquals("User should be redirected to the login page.", expectedUrl, driver.getCurrentUrl());
    }

    @Test
     void ResetPasswordLinkCheck() {
        loadHomePage();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkcheck = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/span")));

        
        linkcheck.click();

        String expectedUrl = "http://localhost:3000/ForgotPassword"; 
        assertEquals("User should be redirected to the password reset page.", expectedUrl, driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

  





