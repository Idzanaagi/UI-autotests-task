package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class StartPage extends TestData {
    WebDriver driver;
    TestData testData = new TestData();

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAddCustomerTab() {
        driver.get(testData.addCustomerTabLink);
    }
    public void openCustomersTab() {
        driver.get(testData.customersTabLink);
    }
    public void openAccountTab() {
        driver.get(testData.openAccountTabLink);
    }
}
