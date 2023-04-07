package pages;

import org.junit.jupiter.api.Assertions;
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
    firstNameField.sendKeys(value);
}
    public void fillLastName(String value) {
        lastNameField.sendKeys(value);
    }
    public void fillPostCode(String value) {
        postCodeField.sendKeys(value);
    }
    public void clickAddCustomerBtn() {
        addCustomerBtn.click();
    }
    public void confirmAction() {
        driver.switchTo().alert().accept();
    }
    public boolean isFieldsEmpty() {
        return firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty();
    }
    public String getNewCeilWithFirstNameValue() {
        return newCellWithFirstName.getText();
    }
    public String getNewCeilWithLastName() {
        return newCellWithLastName.getText();
    }
    public String getNewCeilWithPostCode() {
        return newCellWithPostCode.getText();
    }
    public String getNewCeilWithAccountNumber() {
        return newCellWithAccountNumber.getText();
    }
}
