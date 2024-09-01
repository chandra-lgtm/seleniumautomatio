package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver driver;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "country")
    WebElement countryField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "card")
    WebElement cardField;

    @FindBy(id = "month")
    WebElement monthField;

    @FindBy(id = "year")
    WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseButton;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void placeOrder(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        purchaseButton.click();
    }
}
