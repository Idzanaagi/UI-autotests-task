package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * The type Customers.
 */
public class Customers {

    /**
     * The Driver.
     */
    WebDriver driver;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[1]/td[1]") /* Без фильтрации, когда в таблице несколько элементов*/
    private WebElement firstElementInTableColumn;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[3]/td[1]")
    private WebElement middleElementInFirstNameColumn;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[5]/td[1]")
    private WebElement lastElementInFirstNameColumn;

    @FindBy(xpath = "//table[contains(@class,'table')]/thead/tr/td[1]")
    private WebElement firstNameCeil;

    @FindBy(css = "[ng-model='searchCustomer']")
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
    private WebElement firstnameElCol2;

    @FindBy(xpath = "//table[contains(@class,'table')]/tbody/tr[2]/td[2]")
    private WebElement lastnameElCol2;

    @FindAll({ @FindBy(tagName = "tr"), })
    private List<WebElement> allElementsInList;

    /**
     * Instantiates a new Customers.
     * @param driver the driver
     */
    public Customers(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Sort by first name.
     */
    @Step("Click on the cell first name")
    public void sortByFirstName() {
        firstNameCeil.click();
    }

    /**
     * Gets first element in table column value.
     * @return the first element in table column value
     */
    @Step("Get the value of the first element in the First Name column")
    public String getFirstElementInTableColumnValue() {
        return firstElementInTableColumn.getText();
    }

    /**
     * Gets middle element in table column value.
     * @return the middle element in table column value
     */
    @Step("Get the value of the middle element in the First Name column")
    public String getMiddleElementInTableColumnValue() {
        return middleElementInFirstNameColumn.getText();
    }

    /**
     * Gets last element in table column value.
     * @return the last element in table column value
     */
    @Step("Get the value of the last element in the First Name column")
    public String getLastElementInTableColumnValue() {
        return lastElementInFirstNameColumn.getText();
    }

    /**
     * Click search customers field.
     */
    @Step("Click on the search customer field")
    public void clickSearchCustomersField() {
        searchCustomersField.click();
    }

    /**
     * Fill search customer field.
     * @param value the value
     */
    @Step("Fill in the search customer field")
    public void fillSearchCustomerField(final String value) {
        searchCustomersField.sendKeys(value);
    }

    /**
     * Gets first name with filter.
     * @return the first name with filter
     */
    @Step("Get the value of the first name with filtering")
    public String getFirstNameWithFilter() {
        return firstnameValue.getText();
    }

    /**
     * Gets last name with filter.
     * @return the last name with filter
     */
    @Step("Get the value of the last name with filtering")
    public String getLastNameWithFilter() {
        return lastnameValue.getText();
    }

    /**
     * Gets post code with filter.
     * @return the post code with filter
     */
    @Step("Get the value of the post code with filtering")
    public String getPostCodeWithFilter() {
        return postCodeElement.getText();
    }

    /**
     * Gets account number with filter.
     * @return the account number with filter
     */
    @Step("Get the value of the account number with filtering")
    public String getAccountNumberWithFilter() {
        return accountNumberElement.getText();
    }

    /**
     * Gets first name on line 2.
     * @return the first name on line 2
     */
    @Step("Get the value of the first name on line 2 with filtering")
    public String getFirstNameOnLine2() {
        return firstnameElCol2.getText();
    }

    /**
     * Gets last name on line 2.
     * @return the last name on line 2
     */
    @Step("Get the value of the last name on line 2 with filtering")
    public String getLastNameOnLine2() {
       return lastnameElCol2.getText();
    }

    /**
     * Gets size all elements in customer table.
     * @return the size all elements in customer table
     */
    @Step("Get the number of rows in the table")
    public Integer getSizeAllElementsInCustomerTable() {
        return allElementsInList.size() - 1;
    }
}
