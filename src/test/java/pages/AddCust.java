package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Add cust.
 */
public class AddCust {

    /**
     * The Driver.
     */
    WebDriver driver;

    @FindBy(css = "[ng-model='fName']")
    public WebElement firstNameField;

    @FindBy(css = "[ng-model='lName']")
    public WebElement lastNameField;

    @FindBy(css = "[ng-model='postCd']")
    private WebElement postCodeField;

    @FindBy(css = "[type='submit']")
    private WebElement addCustomerBtn;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[1]")
    private WebElement newCellWithFirstName;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[2]")
    private WebElement newCellWithLastName;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[3]")
    private WebElement newCellWithPostCode;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[4]")
    private WebElement newCellWithAccountNumber;

    /**
     * Instantiates a new Add cust.
     * @param driver the driver
     */
    public AddCust(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Fill first name.
     * @param value the value
     */
    @Step("Fill in the first name field")
    public void fillFirstName(final String value) {
        firstNameField.sendKeys(value);
    }

    /**
     * Fill last name.
     * @param value the value
     */
    @Step("Fill in the last name field")
    public void fillLastName(final String value) {
        lastNameField.sendKeys(value);
    }

    /**
     * Fill post code.
     * @param value the value
     */
    @Step("Fill in the post code field")
    public void fillPostCode(final String value) {
        postCodeField.sendKeys(value);
    }

    /**
     * Click add customer btn.
     */
    @Step("Click add customer button")
    public void clickAddCustomerBtn() {
        addCustomerBtn.click();
    }

    /**
     * Confirm action.
     */
    @Step("Confirm the action in the modal window")
    public void confirmAction() {
        driver.switchTo().alert().accept();
    }

    /**
     * Is fields empty boolean.
     * @return the boolean
     */
    @Step("Check that the first name, last name and post code fields are empty")
    public boolean isFieldsEmpty() {
        return firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty();
    }

    /**
     * Gets new ceil with first name value.
     * @return the new ceil with first name value
     */
    @Step("Get the value of a new cell with the first name")
    public String getNewCeilWithFirstNameValue() {
        return newCellWithFirstName.getText();
    }

    /**
     * Gets new ceil with last name value.
     * @return the new ceil with last name value
     */
    @Step("Get the value of a new cell with the last name")
    public String getNewCeilWithLastNameValue() {
        return newCellWithLastName.getText();
    }

    /**
     * Gets new ceil with post code value.
     * @return the new ceil with post code value
     */
    @Step("Get the value of a new cell with the post code")
    public String getNewCeilWithPostCodeValue() {
        return newCellWithPostCode.getText();
    }

    /**
     * Gets new ceil with account number value.
     * @return the new ceil with account number value
     */
    @Step("Get the value of a new cell with the account number")
    public String getNewCeilWithAccountNumberValue() {
        return newCellWithAccountNumber.getText();
    }
}
