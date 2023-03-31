package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.List;

public class Customers extends Utils {
    WebDriver driver;
    Utils utils = new Utils();

    public Customers(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[1]") /* Без фильтрации, когда в таблице несколько элементов*/
    private WebElement firstElementInTableColumn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[3]/td[1]")
    private WebElement middleElementInFirstNameColumn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[5]/td[1]")
    private WebElement lastElementInFirstNameColumn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/thead/tr/td[1]/a")
    private WebElement firstNameCeil;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")
    private WebElement searchCustomersField;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]") /* С фильтрацией, когда в таблице только один элемент */
    private WebElement firstnameValue;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[2]")
    private WebElement lastnameValue;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[3]")
    private WebElement postCodeElement;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[4]")
    private WebElement accountNumberElement;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[2]/td[1]") /* С фильтрацией, когда в таблице больше 1 элемента */
    private WebElement firstnameEl_col2;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[2]/td[2]")
    private WebElement lastnameEl_col2;
    @FindAll({ @FindBy(tagName = "tr"), })
    private List<WebElement> allElementsInList;

    public void sortByFirstName() {
        firstNameCeil.click();
    }
    public void compareFirstElInDescendingOrder() {
        utils.checkValue(firstElementInTableColumn, "Ron");
    }
    public void compareMiddleElInDescendingOrder() {
        utils.checkValue(middleElementInFirstNameColumn, "Hermoine");
    }
    public void compareLastElInDescendingOrder() {
        utils.checkValue(lastElementInFirstNameColumn, "Albus");
    }
    public void compareFirstElInAscendingOrder() {
        utils.checkValue(firstElementInTableColumn, "Albus");
    }
    public void compareMiddleElInAscendingOrder() {
        utils.checkValue(middleElementInFirstNameColumn, "Hermoine");
    }
    public void compareLastElInAscendingOrder() {
        utils.checkValue(lastElementInFirstNameColumn, "Ron");
    }
    public void clickSearchCustomersField() {
        searchCustomersField.click();
    }
    public void fillSearchCustomerFieldForFirstNameCheck() {
        utils.fillField(searchCustomersField, "ha");
    }
    public void compareFirstNameValue() {
        utils.checkValue(firstnameValue, "Harry");
        utils.checkValue(postCodeElement, "E725JB");
    }
    public void fillSearchCustomerFieldForLastNameCheck() {
        utils.fillField(searchCustomersField, "lo");
    }
    public void compareLastNameValue() {
        utils.checkValue(firstnameValue, "Neville");
        utils.checkValue(lastnameValue, "Longbottom");
    }
    public void fillSearchCustomerFieldForPostCode() {
        utils.fillField(searchCustomersField, "e7");
    }
    public void comparePostCodeValue() {
        utils.checkValue(postCodeElement, "E725JB");
        utils.checkValue(firstnameValue, "Harry");
    }
    public void fillSearchCustomerFieldForAccountNumber() {
        utils.fillField(searchCustomersField, "1014");
    }
    public void compareAccountNumberValue() {
        utils.checkValue(accountNumberElement, "1013 1014 1015");
        utils.checkValue(lastnameValue, "Longbottom");
    }
    public void findNonExistentCustomer() {
        utils.fillField(searchCustomersField, "dd");
    }
    public void fillSearchCustomerFieldForMultipleSearch() {
        utils.fillField(searchCustomersField, "ne");
    }
    public void compareMultipleSearchValue() {
        utils.checkValue(firstnameValue, "Hermoine");
        utils.checkValue(lastnameValue, "Granger");
        utils.checkValue(firstnameEl_col2, "Neville");
        utils.checkValue(lastnameEl_col2, "Longbottom");
    }
    public void getCountEl() {
        Assertions.assertEquals(allElementsInList.size() - 1, 0);
    }
}