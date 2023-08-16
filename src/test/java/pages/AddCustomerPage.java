package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * The type Add cust.
 */
public class AddCustomerPage {

    /**
     * The Driver.
     */
    private final WebDriver driver;

    /**
     * The First name field.
     */
    @FindBy(css = "[ng-model='fName']")
    private WebElement firstNameField;

    /**
     * The Last name field.
     */
    @FindBy(css = "[ng-model='lName']")
    private WebElement lastNameField;

    /**
     * The Post code field.
     */
    @FindBy(css = "[ng-model='postCd']")
    private WebElement postCodeField;

    /**
     * The Add customer btn.
     */
    @FindBy(css = "[type='submit']")
    private WebElement addCustomerBtn;

    /**
     * The New cell with first name.
     */
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[1]")
    private WebElement newCellWithFirstName;

    /**
     * The New cell with last name.
     */
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[2]")
    private WebElement newCellWithLastName;

    /**
     * The New cell with post code.
     */
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[3]")
    private WebElement newCellWithPostCode;

    /**
     * The New cell with account number.
     */
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[4]")
    private WebElement newCellWithAccountNumber;


    /**
     * Instantiates a new Add cust.
     *
     * @param webDriver the web driver
     */
    public AddCustomerPage(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Gets first name field.
     * @return the first name field
     */
    public WebElement getFirstNameField() {
        return firstNameField;
    }

    /**
     * Gets last name field.
     * @return the last name field
     */
    public WebElement getLastNameField() {
        return lastNameField;
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
