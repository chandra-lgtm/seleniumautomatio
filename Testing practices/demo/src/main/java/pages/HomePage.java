package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "signin2")
    WebElement signUpButton;

    @FindBy(id = "login2")
    WebElement loginButton;

    @FindBy(linkText = "Contact")
    WebElement contactButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickContact() {
        contactButton.click();
    }
}