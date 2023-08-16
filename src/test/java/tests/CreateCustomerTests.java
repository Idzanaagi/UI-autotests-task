package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.AddCustomerPage;
import pages.StartPage;
import pages.OpenAccountPage;
import utils.WebdriverSetting;

/**
 * The type Create customer tests.
 */
public class CreateCustomerTests extends WebdriverSetting {

    /**
     * The First name data.
     */
    private final String firstNameData = "testfirstname";

    /**
     * The Last name data.
     */
    private final String lastNameData = "testlastname";

    /**
     * The Post code data.
     */
    private final String postCodeData = "testpostcode";

    /**
     * The Expected alert message.
     */
    private final String expectedAlertMessage = "Customer added successfully with customer id :6";

    /**
     * Check content modal msg.
     */
    @Test
    @DisplayName("CC-1, content of modal msg")
    @Description("CC-1, check the message text of the modal window when the client was successfully added")
    public void checkContentModalMsg() {
        StartPage startPage = new StartPage(getDriver());
        AddCustomerPage addCust = new AddCustomerPage(getDriver());
        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, getDriver().switchTo().alert().getText());
    }

    /**
     * Check add customer to customer page.
     */
    @Test
    @DisplayName("CC-2, add customer to customer page")
    @Description("CC-2, check that after adding a new client its data appears in the table customers")
    public void checkAddCustomerToCustomerPage() {
        StartPage startPage = new StartPage(getDriver());
        AddCustomerPage addCust = new AddCustomerPage(getDriver());
        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, getDriver().switchTo().alert().getText());
        addCust.confirmAction();
        addCust.isFieldsEmpty(); /* проверка, что поля формы очищаются после успешного добавления клиента */
        startPage.openCustomersTab();
        Assertions.assertEquals(addCust.getNewCeilWithFirstNameValue(), firstNameData);
        Assertions.assertEquals(addCust.getNewCeilWithLastNameValue(), lastNameData);
        Assertions.assertEquals(addCust.getNewCeilWithPostCodeValue(), postCodeData);
        Assertions.assertEquals(addCust.getNewCeilWithAccountNumberValue(), "");
    }

    /**
     * Check add customer to open account page.
     */
    @Test
    @DisplayName("CC-3, add customer to open account page")
    @Description("CC-3, check that after adding a new client its data appears in the open account")
    public void checkAddCustomerToOpenAccountPage() {
        StartPage startPage = new StartPage(getDriver());
        AddCustomerPage addCust = new AddCustomerPage(getDriver());
        OpenAccountPage openAccount = new OpenAccountPage(getDriver());
        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.fillLastName(lastNameData);
        addCust.fillPostCode(postCodeData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(expectedAlertMessage, getDriver().switchTo().alert().getText());
        addCust.confirmAction();
        startPage.openAccountTab();
        openAccount.clickCustomersListSelect();
        String expectedValue = "testfirstname testlastname";
        Assertions.assertEquals(openAccount.getLastCustomerListOptionValue(), expectedValue);
    }

    /**
     * Check add customer with all empty data.
     */
    @Test
    @DisplayName("CC-4, try add customer with empty data")
    @Description("CC-4, check that after adding a customer with unfilled data, the first empty field gets the focus")
    public void checkAddCustomerWithAllEmptyData() {
        StartPage startPage = new StartPage(getDriver());
        AddCustomerPage addCust = new AddCustomerPage(getDriver());
        startPage.openAddCustomerTab();
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(getDriver().switchTo().activeElement(), addCust.getFirstNameField());
    }

    /**
     * Check add customer with partially blank data.
     */
    @Test
    @DisplayName("CC-5, try add customer with partially blank data")
    @Description("CC-5, check that after adding a customer with partially filled data, the first empty field gets the focus")
    public void checkAddCustomerWithPartiallyBlankData() {
        StartPage startPage = new StartPage(getDriver());
        AddCustomerPage addCust = new AddCustomerPage(getDriver());
        startPage.openAddCustomerTab();
        addCust.fillFirstName(firstNameData);
        addCust.clickAddCustomerBtn();
        Assertions.assertEquals(getDriver().switchTo().activeElement(), addCust.getLastNameField());
    }
}
