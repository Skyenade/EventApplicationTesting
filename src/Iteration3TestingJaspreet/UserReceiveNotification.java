package Iteration3TestingJaspreet;

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

import static org.junit.jupiter.api.Assertions.*;

class UserReceiveNotification {

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
    public void userLikePostAndViewNotification() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        // Like a post
        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[4]/div[2]/button[1]")));
        
         assertTrue(likeButton.isEnabled(), "Like button should be enabled.");

        likeButton.click();
    }
    
    @Test
    public void likebuttonnotdisable() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        
        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[2]/button[1]")));
        
        // Assert that the like button is not disabled
        assertFalse(likeButton.getAttribute("disabled") != null, "Like button should not be  disabled.");

        likeButton.click();
    }
    
    
    @Test
    public void NotificationafterLikingPost() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        // Like a post (using new XPath)
        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[10]/div[2]/button[1]")));

        
        
        WebElement notificationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[3]/div/h3")));

        
        assertTrue(notificationMessageElement.isDisplayed(), "Notification should be visible after liking the post.");
    }
    
    
    @Test
    public void Dislike() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        
        WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("dislike_btn")));
        
        
        dislikeButton.click();

        WebElement updatedDislikeCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dislike_btn")));
        
        
        assertNotEquals(updatedDislikeCount.getText(), "Previous count", "Dislike count should update after clicking the button.");
    }
    
    
    @Test
    public void NotificationClickviewbutton() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        // Find and click the View button
        WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[3]/div/ul/li[1]/button")));

        // Assert that the notification is initially displayed
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[3]/div/ul/li[1]")));
        assertTrue(notification.isDisplayed(), "Notification should be visible before clicking View.");

        // Click the View button
        viewButton.click();

        // Wait for the notification to disappear
        boolean notificationIsGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[3]/div/ul/li[1]")));

        // Assert that the notification is no longer visible
        assertTrue(notificationIsGone, "Notification should disappear after clicking View.");
    }
    
    
    @Test
    public void NotificationnewFollowers() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/h3[1]\r\n"
        		+ "")));
        
       
        assertFalse(notification.isDisplayed(), "Notification should be visible when a new follower is added.");
    }
    
    @Test
    public void Notificationfollowing() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("jaspreet@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("123456");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/h3[2]\r\n"
        		+ "")));
        
        
        assertFalse(notification.isDisplayed(), "Notification should be visible when a new follower is added.");
    }

    
    
}
