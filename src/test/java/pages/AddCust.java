package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCust {
    WebDriver driver;
    public AddCust(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final String firstNameData = "testfirstname";
    private final String lastNameData = "testlastname";
    private final String postCodeData = "testpostcode";
    private final String emptyValue = "";
    private final String expectedAlertMessage = "Customer added successfully with customer id :6";

    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group']/input")
    private WebElement firstNameField;
    @FindBy(xpath = "//form[@name='myForm']/div[@class='form-group'][2]/input")
    private WebElement lastNameField;
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

    public void fillFirstName() {
    firstNameField.sendKeys(firstNameData);
}
    public void fillLastName() {
        lastNameField.sendKeys(lastNameData);
    }
    public void fillPostCode() {
        postCodeField.sendKeys(postCodeData);
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
        return firstNameField.getText().isEmpty() && lastNameField.getText().isEmpty() && postCodeField.getText().isEmpty();
    }
    public void compareFirstNameValues() {
    Assertions.assertEquals(newCellWithFirstName.getText(), firstNameData);
}
    public void compareLastNameValues() {
        Assertions.assertEquals(newCellWithLastName.getText(), lastNameData);
    }
    public void comparePostCodeValues() {
        Assertions.assertEquals(newCellWithPostCode.getText(), postCodeData);
    }
    public void compareAccountNumberValues() {
        Assertions.assertEquals(newCellWithAccountNumber.getText(), emptyValue);
    }
    public void checkFirstNameFieldFocus() {
        Assertions.assertEquals(driver.switchTo().activeElement(), firstNameField);
    }
    public void checkLastNameFieldFocus() {
        Assertions.assertEquals(driver.switchTo().activeElement(), lastNameField);
    }
}
