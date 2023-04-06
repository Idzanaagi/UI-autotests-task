package tests;

import utils.WebdriverSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.AddCust;
import pages.StartPage;
import pages.OpenAccount;

public class CreateCustomerTests extends WebdriverSetting {

    @Test
    @DisplayName("CC-1, content of modal msg")
    public void checkContentModalMsg() {
        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
    }
    @Test
    @DisplayName("CC-2, add customer to customer page")
    public void checkAddCustomerToCustomerPage() {
        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
        addCust.confirmAction();
        addCust.isFieldEmpty(); /* проверка, что поля формы очищаются после успешного добавления клиента */
        startPage.openCustomersTab();
        addCust.compareFirstNameValues();
        addCust.compareLastNameValues();
        addCust.comparePostCodeValues();
        addCust.compareAccountNumberValues();
    }
    @Test
    @DisplayName("CC-3, add customer to open account page")
    public void checkAddCustomerToOpenAccountPage() {
        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);
        OpenAccount openAccount = new OpenAccount(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
        addCust.confirmAction();
        startPage.openAccountTab();
        openAccount.clickCustomerSelect();
        openAccount.checkNewSelectOption();
    }
    @Test
    @DisplayName("CC-4, try add customer with empty data")
    public void checkAddCustomerWithAllEmptyData() {
        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.clickAddCustomerBtn();
        addCust.checkFirstNameFieldFocus();
    }
    @Test
    @DisplayName("CC-5, try add customer with partially blank data")
    public void checkAddCustomerWithPartiallyBlankData() {
        StartPage startPage = new StartPage(driver);
        AddCust addCust = new AddCust(driver);

        startPage.openAddCustomerTab();
        addCust.fillFirstName();
        addCust.clickAddCustomerBtn();
        addCust.checkLastNameFieldFocus();
    }
}
