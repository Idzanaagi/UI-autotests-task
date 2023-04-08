package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
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

    @Step("Click on the drop-down list of customers")
    public void clickCustomersListSelect() {
        customersListSelect.click();
    }
    @Step("Get the last value in the drop-down list of customers")
    public String getLastCustomerListOptionValue() {
        return lastCustomersListOption.getText();
    }
}
