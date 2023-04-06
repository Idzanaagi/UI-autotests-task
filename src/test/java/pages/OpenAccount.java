package pages;

import org.junit.jupiter.api.Assertions;
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

    private final String expectedValue = "testfirstname testlastname";

    @FindBy(xpath = "//*[@id=\"userSelect\"]")
    private WebElement customerSelect;
    @FindBy(xpath = "//*[@id=\"userSelect\"]/option[7]")
    private WebElement lastCustomerOption;
    public void clickCustomerSelect() {
        customerSelect.click();
    }
    public void checkNewSelectOption() {
        Assertions.assertEquals(lastCustomerOption.getText(),expectedValue);
    }
}
