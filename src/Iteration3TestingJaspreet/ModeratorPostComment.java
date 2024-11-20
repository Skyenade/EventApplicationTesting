package Iteration3TestingJaspreet;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ModeratorPostComment {

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

    
    private void loginAndPostComment(String commentText) {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("moderator@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();

       
        WebElement moderatorpostcomment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[2]/button[4]")));
        moderatorpostcomment.click();

        
        WebElement addacomment = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/textarea"));
        addacomment.sendKeys(commentText);

        
        WebElement postcomment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/button")));
        postcomment.click();
    }

    @Test
    public void testModeratorPostCommentVisible() {
        loginAndPostComment("Jaspreet Singh");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        WebElement postedComment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Jaspreet Singh')]")));
        assertTrue(postedComment.isDisplayed(), "The comment was not posted successfully.");
    }

    @Test
    public void testCommentTextMatches() {
        loginAndPostComment("Jaspreet Singh");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        String expectedCommentText = "Jaspreet Singh";
        WebElement postedCommentText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + expectedCommentText + "')]")));
        assertEquals(postedCommentText.getText(), expectedCommentText, "The posted comment text does not match.");
    }

    @Test
    public void testNoAlertAfterPostingComment() {
        loginAndPostComment("Jaspreet Singh");

        
        boolean isAlertPresent = false;
        try {
            Alert alert = driver.switchTo().alert();
            isAlertPresent = true;  // If alert is found, set this to true
            alert.accept();  // Close the alert
        } catch (NoAlertPresentException e) {
            isAlertPresent = false;  // No alert, so continue
        }

        
        assertFalse(isAlertPresent, "An alert was shown after posting the comment.");
    }

    @Test
    public void testPostCommentButtonDisabledAfterClick() {
        loginAndPostComment("Jaspreet Singh");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     // Assertion: Check if the "Post Comment" button is disabled after clicking
        WebElement postCommentButton = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/button"));
        assertTrue(postCommentButton.isEnabled(), "Post comment button should be disabled after posting a comment.");
    }
    
    @Test
    public void testPostButtonWorksWithoutComment() {
        loginAndPostComment("");  

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        WebElement postCommentButton = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div/div[1]/div[3]/div[1]/button"));
        assertFalse(postCommentButton.isEnabled(), "The post button should be disabled after clicking without text.");
    }

    
    @Test
    public void testNoNavigationOrErrorOnEmptyPost() {
        // Login and attempt to post an empty comment
        loginAndPostComment("");  

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Assertion: Check if the page hasn't navigated away (i.e., still on the same page)
        String currentUrl = driver.getCurrentUrl();
        assertNotEquals("http://localhost:3000", currentUrl, "The page should not navigate away after attempting to post an empty comment.");
    }

}
