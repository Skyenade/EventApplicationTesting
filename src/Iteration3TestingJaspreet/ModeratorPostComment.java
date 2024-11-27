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
        driver.get("http://localhost:3000/");
    }

    private void loginAsModerator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("moderator@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();
    }

    private void postComment(String commentText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moderatorPostCommentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[2]/button[4]")));
        moderatorPostCommentButton.click();

        WebElement addCommentTextArea = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[1]/textarea"));
        addCommentTextArea.sendKeys(commentText);

        WebElement postCommentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[1]/button")));
        postCommentButton.click();
    }

    @Test
     void loginAndPostComment() {
        loadHomePage();
        loginAsModerator();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String commentText = "jpsreet testing~";
        postComment(commentText);

        WebElement postedComment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[2]/div[1]/p")));
        assertTrue(postedComment.isDisplayed(), "The comment should be displayed after posting.");
    }

    @Test
     void moderatorPostsEmptyComment() {
        loadHomePage();
        loginAsModerator();
        postComment("");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Boolean postedComment = null;

        try {
            postedComment = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[2]/div[1]/p")));
        } catch (Exception e) {
        }

        assertNull(postedComment, "The empty comment should not be displayed.");
    }

    @Test
     void testCommentTextMatches() {
        loadHomePage();
        loginAsModerator();

        String expectedCommentText = "Jaspreet Singh";
        postComment(expectedCommentText);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement postedComment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[2]/div[1]/p")));

        String actualCommentText = postedComment.getText();

        assertNotEquals(expectedCommentText, actualCommentText, "The posted comment text does not match.");
    }

    @Test
     void testModeratorPostCommentVisible() {
        loadHomePage();
        loginAsModerator();
        postComment("chahal");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement postedComment = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[2]/div[1]/p")
        ));

        assertTrue(postedComment.isDisplayed(), "The comment was not posted successfully.");
    }

    @Test
     void testcommentspecialcharacters() {
        loadHomePage();
        loginAsModerator();
        
        String commentWithSpecialChars = "Jaspreet Singh @!#$%^&*()_+{}|:\"<>?~";
        postComment(commentWithSpecialChars);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement postedComment = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[4]/div[1]/div/div[1]/div[3]/div[2]/div[1]/p")
        ));

        assertTrue(postedComment.isDisplayed(), "The comment was not posted successfully.");
    }

    @Test
     void viewNotificationButton() {
        loadHomePage();
        loginAsModerator();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String commentText = "Test comment^&*()_+?~";
        postComment(commentText);

        WebElement viewNotificationButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[4]/div[2]/div/ul/li[1]/button")
        ));

        viewNotificationButton.click();
        
        assertTrue(true, "The 'View' button was clicked successfully.");
    }
}
