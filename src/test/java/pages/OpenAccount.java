package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Open account.
 */
public class OpenAccount {

    /**
     * The Driver.
     */
    WebDriver driver;

    @FindBy(id = "userSelect")
    private WebElement customersListSelect;

    @FindBy(xpath = "//*[@id=\"userSelect\"]/option[7]")
    private WebElement lastCustomersListOption;

    /**
     * Instantiates a new Open account.
     * @param driver the driver
     */
    public OpenAccount(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click customers list select.
     */
    @Step("Click on the drop-down list of customers")
    public void clickCustomersListSelect() {
        customersListSelect.click();
    }

    /**
     * Gets last customer list option value.
     * @return the last customer list option value
     */
    @Step("Get the last value in the drop-down list of customers")
    public String getLastCustomerListOptionValue() {
        return lastCustomersListOption.getText();
    }
}
