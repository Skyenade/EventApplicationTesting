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

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}

	
    private void loadHomePage() {
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
    }

      @Test
     void AdminDashboardPage() {
        loadHomePage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/input[1]")));
        emailField.sendKeys("admin@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        passwordField.sendKeys("admin1234");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
        loginButton.click();
        
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement Admindashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/h4/a\r\n"
        		+ "")));
        Admindashboard.click();

        WebDriverWait waitingtodashboardpage = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement Usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/a\r\n"
        		+ "")));
        Usermanagement.click();
        
        

        
        

    }
    
    
    public static String getBaseURL(String fullUrl) {
        
        if (fullUrl.contains("/UserManagement")) {
            return fullUrl.split("/UserManagement")[0] + "/UserManagement"; 
        } else {
            return fullUrl;
        }
    }


    
    @Test
     void testAdminHomepageLink() {
        AdminDashboardPage();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url); 
        
       
        String expectedUrl = "http://localhost:3000/UserManagement";
        
        
        String baseURL = getBaseURL(url);
        
                assertEquals(expectedUrl, baseURL);        
    }
    
    @Test
     void  Testinguseraccount(){
    	AdminDashboardPage();
    WebElement crateuseraccount = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button\r\n"
    		+ ""));	
    crateuseraccount.click();
    String ExpectedLink = "http://localhost:3000/CreateUser";
    String ActualUrl = driver.getCurrentUrl();
    assertEquals(ExpectedLink,ActualUrl);
    driver.navigate().back();
    }
    
    
    @Test
     void Tablename() {
    	AdminDashboardPage();
        WebElement userTable = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/h2")));
        assertTrue(userTable.isDisplayed());
    }

    @Test
     void AssignUserTOModerator() {
        AdminDashboardPage();
        WebElement jaspreetRow = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]\r\n"
            		+ "")));
        WebElement assignToModerator = jaspreetRow.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[3]/input[2]\r\n"
        		+ "")); // Use relative XPath for better stability
        assignToModerator.click();
        assertTrue(assignToModerator.isSelected());
    }

    @Test
     void AssignModeratorToUser() {
        AdminDashboardPage();
        WebElement jaspreetRow = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]\r\n"
            		+ "")));
        WebElement selectUser = jaspreetRow.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[3]/input[1]\r\n"
        		+ "")); 
        selectUser.click();
        assertTrue(selectUser.isSelected());
    }

    @Test
     void EditProfile() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[1]")
        )).click();

        
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]/input")
        ));
        usernameField.clear(); 
        usernameField.sendKeys("jaguar");

        
        WebElement bioField = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/input\r\n"
        		+ ""));
        bioField.clear();
        bioField.sendKeys("15sep");

        
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button")).click();

        
        String updatedUsername = driver.findElement(
            By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]/input")
        ).getAttribute("value");
        assertEquals("jaguar", updatedUsername);
        
    }

    
    @Test
     void alertdismiss() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[1]")
        )).click();

        
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]/input")
        ));
        usernameField.clear();
        usernameField.sendKeys("jaguar");

        
        WebElement bioField = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/input"));
        bioField.clear();
        bioField.sendKeys("15sep");

        
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button")).click();

        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("User updated successfully!", alert.getText()); 
        alert.accept();  
    }
    
    
    @Test
     void suspendaccountCancel() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]\r\n"
                		+ "")
            )).click();

       
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suspendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[2]")));
        suspendButton.click();

                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Are you sure you want to suspend this user?", alert.getText());

            alert.dismiss();
    }

    @Test
     void suspendaccountOK() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]")
            )).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suspendButton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[2]")));
        suspendButton.click();

        Alert alert = wait2.until(ExpectedConditions.alertIsPresent());
        assertEquals("Are you sure you want to suspend this user?", alert.getText());

        alert.accept();
    }
    
    @Test
     void restoreAccount() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement restoreButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[4]")
        ));
        restoreButton.click();

        WebElement restoredMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[5][contains(text(), 'active')]")
        ));

        assertTrue(restoredMessage.isDisplayed());
    }
    
    @Test
     void deleteAccountCancel() {
    	AdminDashboardPage();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]")
        )).click();

        
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[3]")
        ));
        deleteButton.click();

        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Are you sure you want to delete this user?", alert.getText());

        
        alert.dismiss();
    }
    
    @Test
     void deleteAccountOK() {
        AdminDashboardPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[1]")
        )).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait2.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[10]/td[4]/button[3]")
        ));
        deleteButton.click();

        Alert alert = wait2.until(ExpectedConditions.alertIsPresent());
        assertEquals("Are you sure you want to delete this user?", alert.getText());

        alert.accept();
    }
    

    @AfterEach
    void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
    }







   }
