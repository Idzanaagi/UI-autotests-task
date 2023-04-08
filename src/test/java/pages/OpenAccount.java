package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccount {

    WebDriver driver;

    public OpenAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"userSelect\"]")
    private WebElement customersListSelect;
    @FindBy(xpath = "//*[@id=\"userSelect\"]/option[7]")
    private WebElement lastCustomersListOption;

    public void clickCustomersListSelect() {
        Allure.step("Click on the drop-down list of customers");
        customersListSelect.click();
    }
    public String getLastCustomerListOptionValue() {
        Allure.step("Get the last value in the drop-down list of customers");
        return lastCustomersListOption.getText();
    }
}
