package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class AddCust extends Utils {
    WebDriver driver;
    Utils utils = new Utils();
    public AddCust(WebDriver driver) {
        this.driver = driver;
    }

    private final String firstNameData = "testfirstname";
    private final String lastNameData = "testlastname";
    private final String postCodeData = "testpostcode";
    private final String emptyValue = "";
    private final String expectedAlertMessage = "Customer added successfully with customer id :6";

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[1]/input")
    private WebElement firstNameField;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[2]/input")
    private WebElement lastNameField;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[3]/input")
    private WebElement postCodeField;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/button")
    private WebElement addCustomerBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[1]")
    private WebElement newCellWithFirstName;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[2]")
    private WebElement newCellWithLastName;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[3]")
    private WebElement newCellWithPostCode;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[4]")
    private WebElement newCellWithAccountNumber;

    public void fillFirstName() {
        utils.fillField(firstNameField, firstNameData);
    }
    public void fillLastName() {
        utils.fillField(lastNameField, lastNameData);
    }
    public void fillPostCode() {
        utils.fillField(postCodeField, postCodeData);
    }
    public void clickAddCustomerBtn() {
        addCustomerBtn.click();
    }
    public void getAlertMessage() {
        Assertions.assertEquals(expectedAlertMessage, driver.switchTo().alert().getText());
    }
    public void confirmAction() {
        driver.switchTo().alert().accept();
    }
    public boolean isFieldEmpty() {
        if (firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty()) {
            return true;
        }
        return false;
    }
    public void compareFirstNameValues() {
        utils.checkValue(newCellWithFirstName, firstNameData);
    }
    public void compareLastNameValues() {
        utils.checkValue(newCellWithLastName, lastNameData);
    }
    public void comparePostCodeValues() {
        utils.checkValue(newCellWithPostCode, postCodeData);
    }
    public void compareAccountNumberValues() {
        utils.checkValue(newCellWithAccountNumber, emptyValue);
    }
    public void checkFirstNameFieldFocus() {
        Assertions.assertEquals(driver.switchTo().activeElement(), firstNameField);
    }
    public void checkLastNameFieldFocus() {
        Assertions.assertEquals(driver.switchTo().activeElement(), lastNameField);
    }

}
