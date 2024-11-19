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
    public void CreateAccoutWithValidDetails() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("Testing2@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
        submitButton.click();

    }

    
    @Test
    public void Createaccountwithsamecredentials() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("Testing@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
        submitButton.click();

    }
    
    
    @Test
    public void CreateAccoutWithemailandpasswordwrong() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("Testing.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
        submitButton.click();

    }
    
    
    @Test
    public void Createaccountwithfieldempty() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
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
    public void createAccountWithUsernameEmpty() {
        loadHomePage();

        // Click on the Create Account button
        WebElement createAccountButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]"));
        createAccountButton.click();

        // Locate the username field and leave it empty
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]"));
        usernameField.sendKeys("");  // Leave it empty

        // Fill out the other fields
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]"));
        emailField.sendKeys("Testing@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]"));
        passwordField.sendKeys("Testing@123");

        // Click the submit button
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button"));
        submitButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form"));
        
        assertTrue("Error message should be displayed.", errorMessage.isDisplayed());
    }


           @Test
    public void Createaccountwithemailempty() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("Testing@123");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
        submitButton.click();
    
 
  
  WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div/div/form"));
  
  assertFalse("Error message should be displayed.", errorMessage.isDisplayed());
}

            
    @Test
    public void Createaccountwithpasswordempty() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();

        
        WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[1]\r\n"
        		+ ""));
        Username.sendKeys("Testing");

        WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[2]\r\n"
        		+ ""));
        emailField.sendKeys("Testing@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/input[3]\r\n"
        		+ ""));
        passwordField.sendKeys("");

        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button\r\n"
        		+ ""));
        submitButton.click();
    
    
    String actualValue = "enterpassword";
    String expectedValue = "Wrongpassword";
    assertEquals(expectedValue, actualValue, "The password field is missing.");
}

    
    @Test
    public void Alreadyhaveaccountbuttoncheck() {
        loadHomePage();
        
        WebElement createaccountbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button[2]\r\n"
        		+ ""));
        createaccountbutton.click();
        WebElement alreadyhaveaccount = driver.findElement(By.xpath("/html/body/div/div/div/form/p"
        		+ ""));
        alreadyhaveaccount.click();
    }

        

           
    
    
  @Test
  public void ResetPasswordLinkCheck() {
      loadHomePage();
      
      WebElement  linkcheck = driver.findElement(By.xpath("/html/body/div/div/div/form/span\r\n"
      		
      		+ ""));
      linkcheck.click();
      }

    
  @Test
  public void EnterCorrectEmail() {
      loadHomePage();
      
      WebElement  linkcheck = driver.findElement(By.xpath("/html/body/div/div/div/form/span\r\n"
    		
    		+ ""));
    linkcheck.click();
    
      WebElement Enteremail = driver.findElement(By.xpath("/html/body/div/div/div/form/input\r\n"
      		
      		+ ""));
      Enteremail.sendKeys("Testing@gmail.com");
      WebElement Resetbutton = driver.findElement(By.xpath("/html/body/div/div/div/form/button\r\n"
      		+ ""));
      Resetbutton.click();
  }

    
  @Test
  public void Enterwrongemailforpasswordreset() {
      loadHomePage();
      
      WebElement  linkcheck = driver.findElement(By.xpath("/html/body/div/div/div/form/span\r\n"
    		
    		+ ""));
    linkcheck.click();
    
      WebElement Enteremail = driver.findElement(By.xpath("/html/body/div/div/div/form/input\r\n"
      		
      		+ ""));
      Enteremail.sendKeys("jj");
      WebElement Resetbutton = driver.findElement(By.xpath("/html/body/div/div/div/form/button\r\n"
      		+ ""));
      Resetbutton.click();
      
      String actualValue = "entercorrecemail";
      String expectedValue = "please enter correct email address";
      assertEquals(expectedValue, actualValue, "The password field is missing.");
    } 
    
    
    
    
    @Test
  public void Userloginwithcorrectemail() {
      loadHomePage();

     
     


      WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]\r\n"
      		+ ""));
      emailField.sendKeys("Testing@gmail.com");

      WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]\r\n"
      		+ ""));
      passwordField.sendKeys("Testing@123");

      
      WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]\r\n"
      		+ ""));
      submitButton.click();
      
     
  }
    
    
    @Test
    public void loginwithoutaccountcreation() {
        loadHomePage();

 WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]\r\n"
	+ ""));
emailField.sendKeys("Testg@gmail.com");

WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]\r\n"
	+ ""));
passwordField.sendKeys("Testing@123");


WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]\r\n"
	+ ""));
submitButton.click();

String actualValue = "";
String expectedValue = "user email and passowrd does not exist please create account";
assertEquals(expectedValue, actualValue, "The password field is missing.");
} 
  
 
    
    @Test
    public void UserDeleteAccount() {
        try {
            loadHomePage();
            
            // Enter email and password
            WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
            emailField.sendKeys("cegep@gmail.com");

            WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
            passwordField.sendKeys("cegep@123");

            // Click submit button
            WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button[1]"));
            submitButton.click();

            // Go to user profile
            WebElement userProfileButton = driver.findElement(By.id("userprofile-button"));
            userProfileButton.click();

            // Click delete account button
            WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/button"));
            deleteButton.click();
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            fail("Test failed due to an exception: " + e.getMessage());
        }
        
        
    }
    @AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
    
    
}
      
  
    
    

}
  
    




      
      
      
      
  
  
  





