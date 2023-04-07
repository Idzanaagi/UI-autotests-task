package pages;

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

    public void sortByFirstName() {
        firstNameCeil.click();
    }
    public String getFirstElementInTableColumnValue() {
        return firstElementInTableColumn.getText();
    }
    public String getMiddleElementInTableColumnValue() {
        return middleElementInFirstNameColumn.getText();
    }
    public String getLastElementInTableColumnValue() {
        return lastElementInFirstNameColumn.getText();
    }
    public void clickSearchCustomersField() {
        searchCustomersField.click();
    }
    public void fillSearchCustomerFieldForFirstNameCheck(String value) {
        searchCustomersField.sendKeys(value);
    }
    public void fillSearchCustomerFieldForLastNameCheck(String value) {
        searchCustomersField.sendKeys(value);
    }
    public void fillSearchCustomerFieldForPostCode(String value) {
        searchCustomersField.sendKeys(value);
    }
    public void fillSearchCustomerFieldForAccountNumber(String value) {
        searchCustomersField.sendKeys(value);
    }
    public void findNonExistentCustomer(String value) {
        searchCustomersField.sendKeys(value);
    }
    public void fillSearchCustomersFieldForMultipleSearch(String value) {
        searchCustomersField.sendKeys(value);
    }
    public String getFirstNameWithFilter() {
        return firstnameValue.getText();
    }
    public String getLastNameWithFilter() {
        return lastnameValue.getText();
    }
    public String getPostCodeWithFilter() {
        return postCodeElement.getText();
    }
    public String getAccountNumberWithFilter() {
        return accountNumberElement.getText();
    }
    public String getFirstNameOnLine2() {
        return firstnameEl_col2.getText();
    }
    public String getLastNameOnLine2() {
       return lastnameEl_col2.getText();
    }
    public Integer getSizeAllElementsInCustomerTable() {
        return allElementsInList.size() - 1;
    }
}