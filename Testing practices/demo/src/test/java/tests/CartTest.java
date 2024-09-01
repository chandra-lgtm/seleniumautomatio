package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class CartTest {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com");
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        String[] items = {"Samsung galaxy s7", "Nokia lumia 1520", "Iphone 6 32gb"};
        int expectedTotalPrice = 2410;

        for (String item : items) {
            cartPage.addItemToCart(item);
            
        }

        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        int totalPrice = cartPage.getTotalPrice();

        Assert.assertEquals(totalPrice, expectedTotalPrice, "Total price in cart does not match expected value.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
