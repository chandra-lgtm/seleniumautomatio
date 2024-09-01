package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;

    @FindBy(id = "recipient-email")
    WebElement contactEmail;

    @FindBy(id = "recipient-name")
    WebElement contactName;

    @FindBy(id = "message-text")
    WebElement messageBox;

    @FindBy(xpath = "//button[text()='Send message']")
    WebElement sendMessageButton;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String email, String name, String message) throws InterruptedException {
        contactEmail.sendKeys(email);
        contactName.sendKeys(name);
        messageBox.sendKeys(message);
        sendMessageButton.click();
       
    }
}
