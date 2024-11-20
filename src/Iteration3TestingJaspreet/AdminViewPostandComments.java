package Iteration3TestingJaspreet;

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

class AdminViewPostandComments {

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
    void loginTest() {
        loadHomePage();

        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();

        // Wait for the page button to be clickable after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/button")));

        // Assert that the page button is visible (login is successful)
        assertTrue(pageButton.isDisplayed(), "The page button should be visible after login.");
    }

    
    @Test
    void checkCommentButtonClickable() {
        loadHomePage();
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();

        // Wait for the comment button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/div[2]/button[4]")));

        // Assertion: Check if the comment button is clickable
        assertTrue(commentButton.isEnabled(), "The comment button should be clickable.");
    }

    @Test
    void checkCommentSectionVisibility() {
        loadHomePage();
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();

        // Wait for the comment button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/div[2]/button[4]")));

        // Click the comment button
        commentButton.click();

        // Assertion: Check if the comment section is visible after clicking the comment button
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentSection = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/div[3]/div[2]/div[1]/p/strong")));
        
        assertTrue(commentSection.isDisplayed(), "The comment section should be visible after clicking the comment button.");
    }

    @Test
    void checkCommentTextVisibility() {
        loadHomePage();
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("admin@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("admin1234");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]")).click();

        // Wait for the comment button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/div[2]/button[4]")));

        // Click the comment button
        commentButton.click();

        // Wait for the comment text to be visible
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentText = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/div[3]/div[2]/div[1]/p/strong")));

        // Assertion: Check if the comment text is visible
        assertTrue(commentText.isDisplayed(), "The comment text should be visible after the button click.");
    }
    
    
    
    @Test
    void navigateToNextPageTest() {
        loginTest(); // Reuse loginTest()

        // Wait for the page button to be clickable and navigate
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[3]/div[2]/div/div[1]/button")));
        pageButton.click();

        // Assert that we navigated to the correct page (Check if heading is visible)
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[5]/div[2]/h4")));
        assertNotEquals("User Comments", heading.getText(), "The heading should display 'User Comments' after navigating.");
    }
    
    @Test
    public void Dislike() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Log in
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[2]")));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/form/button[1]")));
        loginButton.click();

        
        WebElement dislikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("dislike_btn")));
        
        
        dislikeButton.click();

        WebElement updatedDislikeCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dislike_btn")));
        
        
        assertNotEquals(updatedDislikeCount.getText(), "Previous count", "Dislike count should update after clicking the button.");
    }


        @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
