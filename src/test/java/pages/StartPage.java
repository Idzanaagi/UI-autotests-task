package pages;

import io.qameta.allure.Allure;
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

    public void openAddCustomerTab() {
        Allure.step("Open the add customers tab");
        driver.get(testData.addCustomerTabLink);
    }
    public void openCustomersTab() {
        Allure.step("Open the customers tab");
        driver.get(testData.customersTabLink);
    }
    public void openAccountTab() {
        Allure.step("Open the open account tab");
        driver.get(testData.openAccountTabLink);
    }
}
