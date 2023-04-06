package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Customers {
    WebDriver driver;
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
        Assertions.assertEquals(firstElementInTableColumn.getText(), "Ron");
    }
    public void compareLastElInDescendingOrder() {
        Assertions.assertEquals(lastElementInFirstNameColumn.getText(), "Albus");
    }
    public void compareFirstElInAscendingOrder() {
        Assertions.assertEquals(firstElementInTableColumn.getText(), "Albus");
    }
    public void compareMiddleElInAscendingOrder() {
        System.out.println(middleElementInFirstNameColumn.getText());
        Assertions.assertEquals(middleElementInFirstNameColumn.getText(), "Hermoine");
    }
    public void compareLastElInAscendingOrder() {
        Assertions.assertEquals(lastElementInFirstNameColumn.getText(), "Ron");
    }
    public void clickSearchCustomersField() {
        searchCustomersField.click();
    }
    public void fillSearchCustomerFieldForFirstNameCheck() {
        searchCustomersField.sendKeys("ha");
    }
    public void compareFirstNameValue() {
        Assertions.assertEquals(firstnameValue.getText(), "Harry");
        Assertions.assertEquals(postCodeElement.getText(), "E725JB");
    }
    public void fillSearchCustomerFieldForLastNameCheck() {
        searchCustomersField.sendKeys("lo");
    }
    public void compareLastNameValue() {
        Assertions.assertEquals(firstnameValue.getText(), "Neville");
        Assertions.assertEquals(lastnameValue.getText(), "Longbottom");
    }
    public void fillSearchCustomerFieldForPostCode() {
        searchCustomersField.sendKeys("e7");
    }
    public void comparePostCodeValue() {
        Assertions.assertEquals(postCodeElement.getText(),"E725JB");
        Assertions.assertEquals(firstnameValue.getText(),"Harry");
    }
    public void fillSearchCustomerFieldForAccountNumber() {
        searchCustomersField.sendKeys("1014");
    }
    public void compareAccountNumberValue() {
        Assertions.assertEquals(accountNumberElement.getText(),"1013 1014 1015");
        Assertions.assertEquals(lastnameValue.getText(),"Longbottom");
    }
    public void findNonExistentCustomer() {
        searchCustomersField.sendKeys("dd");
    }
    public void fillSearchCustomerFieldForMultipleSearch() {
        searchCustomersField.sendKeys("ne");
    }
    public void compareMultipleSearchValue() {
        Assertions.assertEquals(firstnameValue.getText(),"Hermoine");
        Assertions.assertEquals(lastnameValue.getText(),"Granger");
        Assertions.assertEquals(firstnameEl_col2.getText(),"Neville");
        Assertions.assertEquals(lastnameEl_col2.getText(),"Longbottom");
    }
    public void getCountEl(int num) {
        Assertions.assertEquals(allElementsInList.size() - 1, num);
    }
}