package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;

public class OrderTest {

    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    OrderPage orderPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com");
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void placeOrderTest() throws InterruptedException {

        cartPage.addItemToCart("Samsung galaxy s7");
        cartPage.addItemToCart("Nokia lumia 1520");
        cartPage.addItemToCart("Iphone 6 32gb");

        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        cartPage.clickOrder();
        // Place order
        orderPage.placeOrder("Test Name", "USA", "New York", "1234567890123456", "12", "2024");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();

        Thread.sleep(5000);
        driver.findElement(By.linkText("Cart")).click();
        // Validate that the cart is empty after placing order
        List<String> cartItems = cartPage.getCartItems();
        Assert.assertTrue(cartItems.isEmpty(), "Cart is not empty after placing the order.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
