package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestData;

public class AddCust extends TestData {

    WebDriver driver;

    public AddCust(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group']/input")
    public WebElement firstNameField;
    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group'][2]/input")
    public WebElement lastNameField;
    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group'][3]/input")
    private WebElement postCodeField;
    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group'][3]/following-sibling::button[@type='submit']")
    private WebElement addCustomerBtn;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[1]")
    private WebElement newCellWithFirstName;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[2]")
    private WebElement newCellWithLastName;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[3]")
    private WebElement newCellWithPostCode;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[6]/td[4]")
    private WebElement newCellWithAccountNumber;

    @Step("Fill in the first name field")
    public void fillFirstName(String value) {
        firstNameField.sendKeys(value);
    }
    @Step("Fill in the last name field")
    public void fillLastName(String value) {
        lastNameField.sendKeys(value);
    }
    @Step("Fill in the post code field")
    public void fillPostCode(String value) {
        postCodeField.sendKeys(value);
    }
    @Step("Click add customer button")
    public void clickAddCustomerBtn() {
        addCustomerBtn.click();
    }
    @Step("Confirm the action in the modal window")
    public void confirmAction() {
        driver.switchTo().alert().accept();
    }
    @Step("Check that the first name, last name and post code fields are empty")
    public boolean isFieldsEmpty() {
        return firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty();
    }
    @Step("Get the value of a new cell with the first name")
    public String getNewCeilWithFirstNameValue() {
        return newCellWithFirstName.getText();
    }
    @Step("Get the value of a new cell with the last name")
    public String getNewCeilWithLastNameValue() {
        return newCellWithLastName.getText();
    }
    @Step("Get the value of a new cell with the post code")
    public String getNewCeilWithPostCodeValue() {
        return newCellWithPostCode.getText();
    }
    @Step("Get the value of a new cell with the account number")
    public String getNewCeilWithAccountNumberValue() {
        return newCellWithAccountNumber.getText();
    }
}
