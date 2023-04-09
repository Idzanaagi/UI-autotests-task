package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.TestData;

public class StartPage extends TestData {

    WebDriver driver;

    TestData testData = new TestData();

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Open the add customers tab")
    public void openAddCustomerTab() {
        driver.get(testData.addCustomerTabLink);
    }
    @Step("Open the customers tab")
    public void openCustomersTab() {
        driver.get(testData.customersTabLink);
    }
    @Step("Open the open account tab")
    public void openAccountTab() {
        driver.get(testData.openAccountTabLink);
    }
}
