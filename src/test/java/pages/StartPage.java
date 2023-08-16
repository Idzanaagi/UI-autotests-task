package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static utils.DataProperties.readProperty;

/**
 * The type Start page.
 */
public class StartPage {

    /**
     * The Driver.
     */
    private final WebDriver driver;

    /**
     * Instantiates a new Start page.
     * @param webDriver the driver
     */
    public StartPage(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Open add customer tab.
     */
    @Step("Open the add customers tab")
    public void openAddCustomerTab() {
        driver.get(readProperty("addCustomerTabLink"));
    }

    /**
     * Open customers tab.
     */
    @Step("Open the customers tab")
    public void openCustomersTab() {
        driver.get(readProperty("customersTabLink"));
    }

    /**
     * Open account tab.
     */
    @Step("Open the open account tab")
    public void openAccountTab() {
        driver.get(readProperty("openAccountTabLink"));
    }
}
