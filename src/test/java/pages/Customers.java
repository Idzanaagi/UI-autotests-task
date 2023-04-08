package pages;

import io.qameta.allure.Allure;
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

    public void sortByFirstName() {
        Allure.step("Click on the cell first name");
        firstNameCeil.click();
    }
    public String getFirstElementInTableColumnValue() {
        Allure.step("Get the value of the first element in the First Name column");
        return firstElementInTableColumn.getText();
    }
    public String getMiddleElementInTableColumnValue() {
        Allure.step("Get the value of the middle element in the First Name column");
        return middleElementInFirstNameColumn.getText();
    }
    public String getLastElementInTableColumnValue() {
        Allure.step("Get the value of the last element in the First Name column");
        return lastElementInFirstNameColumn.getText();
    }
    public void clickSearchCustomersField() {
        Allure.step("Click on the search customer field");
        searchCustomersField.click();
    }
    public void fillSearchCustomerField(String value) {
        Allure.step("Fill in the search customer field");
        searchCustomersField.sendKeys(value);
    }
    public String getFirstNameWithFilter() {
        Allure.step("Get the value of the first name with filtering");
        return firstnameValue.getText();
    }
    public String getLastNameWithFilter() {
        Allure.step("Get the value of the last name with filtering");
        return lastnameValue.getText();
    }
    public String getPostCodeWithFilter() {
        Allure.step("Get the value of the post code with filtering");
        return postCodeElement.getText();
    }
    public String getAccountNumberWithFilter() {
        Allure.step("Get the value of the account number with filtering");
        return accountNumberElement.getText();
    }
    public String getFirstNameOnLine2() {
        Allure.step("Get the value of the first name on line 2 with filtering");
        return firstnameEl_col2.getText();
    }
    public String getLastNameOnLine2() {
       Allure.step("Get the value of the last name on line 2 with filtering");
       return lastnameEl_col2.getText();
    }
    public Integer getSizeAllElementsInCustomerTable() {
        Allure.step("Get the number of rows in the table");
        return allElementsInList.size() - 1;
    }
}