package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static base.BaseClass.logger;

public class LoginTest {
    WebDriver driver;
    String validUsername = "Admin";
    String validPassword = "admin123";
    String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    public void validLogin(){
        HomePage homePage = new HomePage();

        homePage.enterUsername("Admin");
        homePage.enterPassword("admin123");
        homePage.clicklogin();
        Assert.assertTrue(true);

    }
}
