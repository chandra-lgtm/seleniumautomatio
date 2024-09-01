package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import pages.ContactPage;
import pages.HomePage;
import utils.CSVReader1;

public class ContactTest {
    WebDriver driver;
    HomePage homePage;
    ContactPage contactPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com");
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test(dataProvider = "contactData")
    public void contactTest(String email, String name, String message) throws InterruptedException {
        homePage.clickContact();
        contactPage.sendMessage(email, name, message);
        String alertMessage=driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage,"Thanks for the message!!");
        driver.switchTo().alert().accept();
        
    }

    @DataProvider(name = "contactData")
    public Object[][] getContactData() throws CsvValidationException {
        List<String[]> data = CSVReader1.readCSV("src/test/resources/contactData.csv");
        return data.toArray(new Object[0][]);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
