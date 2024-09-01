package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//comment conflict
public class CartPage {
    WebDriver driver;
    @FindBy(xpath="//a[contains(text(),'Home')]")
    WebElement home;


    @FindBy(css = ".success td:nth-child(2)")
    List<WebElement> cartItems;

    @FindBy(css = ".success td:nth-child(3)")
    List<WebElement> cartPrices;

    @FindBy(id = "totalp")
    WebElement totalPrice;

    @FindBy(xpath="//button[contains(text(),'Place Order')]")
    WebElement placeOrder;
    

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(String itemName) throws InterruptedException {
        
        driver.findElement(By.linkText(itemName)).click();
       
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        home.click();
    }

    public List<String> getCartItems() {
        return cartItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Integer> getCartPrices() {
        return cartPrices.stream().map(element -> Integer.parseInt(element.getText())).collect(Collectors.toList());
    }

    public int getTotalPrice() {
        return Integer.parseInt(totalPrice.getText());
    }
    public void clickOrder(){
        placeOrder.click();
    }
}
