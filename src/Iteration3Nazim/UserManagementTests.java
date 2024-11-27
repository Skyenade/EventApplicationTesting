package Iteration3Nazim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserManagementTests {

    WebDriver driver = new ChromeDriver();

 
    public void loadAdminDashboard() {
        
        driver.get("http://localhost:3000");

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[1]")));
        inputField.sendKeys("admin@gmail.com");

        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/input[2]")));
        passwordField.sendKeys("admin1234");

       
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/form/button[1]")));
        submitBtn.click();

    
        wait.until(ExpectedConditions.urlContains("/AdminHome"));

      
        WebElement adminDashboardLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[3]/div[1]/h4/a")));
        adminDashboardLink.click();

       
        wait.until(ExpectedConditions.urlContains("/AdminDashboard"));

       
        WebElement userManagementBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/a")));
        userManagementBtn.click();

        
        wait.until(ExpectedConditions.urlContains("/UserManagement"));
    }

    
    public void testEditProfileButtonPresence() {
        loadAdminDashboard(); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[1]")));
        System.out.println("Edit Profile button is present: " + (editProfileBtn.isDisplayed() ? "Yes" : "No"));
    }

    public void testSuspendAccountButtonPresence() {
        loadAdminDashboard(); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suspendAccountBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[2]")));
        System.out.println("Suspend Account button is present: " + (suspendAccountBtn.isDisplayed() ? "Yes" : "No"));
    }

    public void testDeleteAccountButtonPresence() {
        loadAdminDashboard(); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteAccountBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[3]")));
        System.out.println("Delete Account button is present: " + (deleteAccountBtn.isDisplayed() ? "Yes" : "No"));
    }

    
    public void testRestoreButtonPresence() {
        loadAdminDashboard(); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement restoreBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[4]")));
        System.out.println("Restore button is present: " + (restoreBtn.isDisplayed() ? "Yes" : "No"));
    }


    public void testDeleteProfileButtonPresence() {
        loadAdminDashboard(); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[5]")));
        System.out.println("Delete Profile button is present: " + (deleteProfileBtn.isDisplayed() ? "Yes" : "No"));
    }

  
    public void testRestoreProfileButtonPresence() {
        loadAdminDashboard();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement restoreProfileBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/button[6]")));
        System.out.println("Restore Profile button is present: " + (restoreProfileBtn.isDisplayed() ? "Yes" : "No"));
    }
}
