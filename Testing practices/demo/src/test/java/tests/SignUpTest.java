package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTest {
    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com");
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void signUpTest() throws Exception {
        String username = "randomUser1" + System.currentTimeMillis();
        String password = "randomPassword";

        homePage.clickSignUp();
        signUpPage.signUp(username, password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        // Validate sign up by logging in
        homePage.clickLogin();
        loginPage.login(username, password);

        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
