package pages;

import io.qameta.allure.Allure;
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

    public void fillFirstName(String value) {
        Allure.step("Fill in the first name field");
        firstNameField.sendKeys(value);
    }
    public void fillLastName(String value) {
        Allure.step("Fill in the last name field");
        lastNameField.sendKeys(value);
    }
    public void fillPostCode(String value) {
        Allure.step("Fill in the post code field");
        postCodeField.sendKeys(value);
    }
    public void clickAddCustomerBtn() {
        Allure.step("Click add customer button");
        addCustomerBtn.click();
    }
    public void confirmAction() {
        Allure.step("Confirm the action in the modal window");
        driver.switchTo().alert().accept();
    }
    public boolean isFieldsEmpty() {
        Allure.step("Check that the first name, last name and post code fields are empty");
        return firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty();
    }
    public String getNewCeilWithFirstNameValue() {
        Allure.step("Get the value of a new cell with the first name");
        return newCellWithFirstName.getText();
    }
    public String getNewCeilWithLastNameValue() {
        Allure.step("Get the value of a new cell with the last name");
        return newCellWithLastName.getText();
    }
    public String getNewCeilWithPostCodeValue() {
        Allure.step("Get the value of a new cell with the post code");
        return newCellWithPostCode.getText();
    }
    public String getNewCeilWithAccountNumberValue() {
        Allure.step("Get the value of a new cell with the account number");
        return newCellWithAccountNumber.getText();
    }
}
