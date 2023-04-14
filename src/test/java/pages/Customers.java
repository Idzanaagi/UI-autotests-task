package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Customers {

    WebDriver driver;

    public Customers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[1]/td[1]") /* Без фильтрации, когда в таблице несколько элементов*/
    private WebElement firstElementInTableColumn;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[3]/td[1]")
    private WebElement middleElementInFirstNameColumn;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[5]/td[1]")
    private WebElement lastElementInFirstNameColumn;
    @FindBy(xpath = "//table[contains(@class,'table')]/thead/tr/td[1]")
    private WebElement firstNameCeil;
    @FindBy(xpath = "//div[@class='input-group']/input")
    private WebElement searchCustomersField;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr/td[1]") /* С фильтрацией, когда в таблице только один элемент */
    private WebElement firstnameValue;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr/td[2]")
    private WebElement lastnameValue;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr/td[3]")
    private WebElement postCodeElement;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr/td[4]")
    private WebElement accountNumberElement;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[2]/td[1]") /* С фильтрацией, когда в таблице больше 1 элемента */
    private WebElement firstnameEl_col2;
    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[2]/td[2]")
    private WebElement lastnameEl_col2;
    @FindAll({ @FindBy(tagName = "tr"), })
    private List<WebElement> allElementsInList;

    @Step("Click on the cell first name")
    public void sortByFirstName() {
        firstNameCeil.click();
    }
    @Step("Get the value of the first element in the First Name column")
    public String getFirstElementInTableColumnValue() {
        return firstElementInTableColumn.getText();
    }
    @Step("Get the value of the middle element in the First Name column")
    public String getMiddleElementInTableColumnValue() {
        return middleElementInFirstNameColumn.getText();
    }
    @Step("Get the value of the last element in the First Name column")
    public String getLastElementInTableColumnValue() {
        return lastElementInFirstNameColumn.getText();
    }
    @Step("Click on the search customer field")
    public void clickSearchCustomersField() {
        searchCustomersField.click();
    }
    @Step("Fill in the search customer field")
    public void fillSearchCustomerField(String value) {
        searchCustomersField.sendKeys(value);
    }
    @Step("Get the value of the first name with filtering")
    public String getFirstNameWithFilter() {
        return firstnameValue.getText();
    }
    @Step("Get the value of the last name with filtering")
    public String getLastNameWithFilter() {
        return lastnameValue.getText();
    }
    @Step("Get the value of the post code with filtering")
    public String getPostCodeWithFilter() {
        return postCodeElement.getText();
    }
    @Step("Get the value of the account number with filtering")
    public String getAccountNumberWithFilter() {
        return accountNumberElement.getText();
    }
    @Step("Get the value of the first name on line 2 with filtering")
    public String getFirstNameOnLine2() {
        return firstnameEl_col2.getText();
    }
    @Step("Get the value of the last name on line 2 with filtering")
    public String getLastNameOnLine2() {
       return lastnameEl_col2.getText();
    }
    @Step("Get the number of rows in the table")
    public Integer getSizeAllElementsInCustomerTable() {
        return allElementsInList.size() - 1;
    }
}