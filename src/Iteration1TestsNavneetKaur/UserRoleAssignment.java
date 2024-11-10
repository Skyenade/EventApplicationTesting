package Iteration1TestsNavneetKaur;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class UserRoleAssignment {

	private WebDriver driver;
    WebDriverWait wait;
	 

	    @BeforeEach
	    public void setUp() {
	    	driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        driver.get("http://localhost:3000/UserManagement"); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    }

	    @AfterEach
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	    
	    @Test
	    public void UserManagementHeader () {
	        WebElement Titlepath = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/h1"));
	        String expectedTitle = "Admin Dashboard";
	        String actualTitle = Titlepath.getText();
	        assertTrue(actualTitle.contains(expectedTitle));
	    }
	    
	    
	    @Test
	    public void  Test_CreateUserAccountButton(){
	    WebElement Buttonpath = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/button/a"));	
	    Buttonpath.click();
	    String ExpectedLink = "http://localhost:3000/CreateUser";
	    String ActualUrl = driver.getCurrentUrl();
        assertEquals(ExpectedLink,ActualUrl);
	    driver.navigate().back();
	    }
	    
	    @Test
	    public void testTable_Name() {
	        WebElement userTable = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/h2"));
	        assertTrue(userTable.isDisplayed());
	    }
	    
	    @Test
	    public void UserList_Displays() {
	        WebElement userRow = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/h2"));
	        assertNotNull(userRow);
	    }
	    
	    @Test
	    public void Test_UserTOModerator() {
	        WebElement userRow = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[5]/td[2]"));
	        WebElement Selectmoderator = userRow.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[7]/td[3]/input[2]"));
	        
	        Selectmoderator.click();
	        
	        assertTrue(Selectmoderator.isSelected());
	    }
	    
	    @Test
	    public void test_ModeratorToUser() {
	        WebElement userRow = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[14]/td[2]"));
	        WebElement SelectUser = userRow.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/table/tbody/tr[14]/td[3]/input[1]"));
	        SelectUser.click();
	        assertTrue(SelectUser.isSelected());
	    }
	    

	    @Test
	    public void testEditButton_Alert() {
	        WebElement editButton = driver.findElement(By.xpath("//button[text()='Edit']"));
	        editButton.click();
	        assertTrue(driver.switchTo().alert().getText().contains("Edit user with ID"));
	        driver.switchTo().alert().dismiss();
	    }

	    @Test
	    public void testSuspend_onfirmation() {
	        WebElement suspendButton = driver.findElement(By.xpath("//button[text()='Suspend']"));
	        suspendButton.click();
	        assertEquals("Are you sure you want to suspend this user?", 
	                driver.switchTo().alert().getText());
	        driver.switchTo().alert().dismiss();
	    }

	    
}
