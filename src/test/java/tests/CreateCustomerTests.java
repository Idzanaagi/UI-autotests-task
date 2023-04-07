package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.AddCust;
import pages.StartPage;
import pages.OpenAccount;
import utils.WebdriverSetting;

public class CreateCustomerTests extends WebdriverSetting {

    private final String firstNameData = "testfirstname";
    private final String lastNameData = "testlastname";
    private final String postCodeData = "testpostcode";
    private final String expectedAlertMessage = "Customer added successfully with customer id :6";

    @Test
    @DisplayName("CC-1, content of modal msg")
    public void checkContentModalMsg() {

        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, driver.switchTo().alert().getText());
    }

    @Test
    @DisplayName("CC-2, add customer to customer page")
    public void checkAddCustomerToCustomerPage() {

        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, driver.switchTo().alert().getText());
        addCust.confirmAction();
        addCust.isFieldsEmpty(); /* проверка, что поля формы очищаются после успешного добавления клиента */
        startPage.openCustomersTab();
        Assertions.assertEquals(addCust.getNewCeilWithFirstNameValue(), firstNameData);
        Assertions.assertEquals(addCust.getNewCeilWithLastNameValue(), lastNameData);
        Assertions.assertEquals(addCust.getNewCeilWithPostCodeValue(), postCodeData);
        Assertions.assertEquals(addCust.getNewCeilWithAccountNumberValue(), "");
    }

    @Test
    @DisplayName("CC-3, add customer to open account page")
    public void checkAddCustomerToOpenAccountPage() {

        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);
        OpenAccount openAccount = new OpenAccount(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, driver.switchTo().alert().getText());

        addCust.confirmAction();
        startPage.openAccountTab();
        openAccount.clickCustomersListSelect();
        String expectedValue = "testfirstname testlastname";
        Assertions.assertEquals(openAccount.getLastCustomerListOptionValue(), expectedValue);
    }

    @Test
    @DisplayName("CC-4, try add customer with empty data")
    public void checkAddCustomerWithAllEmptyData() {

        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(driver.switchTo().activeElement(), addCust.firstNameField);
    }

    @Test
    @DisplayName("CC-5, try add customer with partially blank data")
    public void checkAddCustomerWithPartiallyBlankData() {

        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(driver.switchTo().activeElement(), addCust.lastNameField);
    }
}
