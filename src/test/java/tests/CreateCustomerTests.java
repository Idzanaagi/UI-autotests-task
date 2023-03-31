package tests;

import utils.WebdriverSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.AddCust;
import pages.StartPage;
import pages.OpenAccount;

public class CreateCustomerTests extends WebdriverSetting {
    private final String addCustomerTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust";
    private final String customersTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
    private final String openAccountTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount";

    @Test
    @DisplayName("CC-1, content of modal msg")
    public void checkContentModalMsg() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        AddCust addCust = PageFactory.initElements(driver, AddCust.class);

        startPage.open(addCustomerTabLink);
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
    }
    @Test
    @DisplayName("CC-2, add customer to customer page")
    public void checkAddCustomerToCustomerPage() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        AddCust addCust = PageFactory.initElements(driver, AddCust.class);

        startPage.open(addCustomerTabLink);
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
        addCust.confirmAction();
        addCust.isFieldEmpty(); /* проверка, что поля формы очищаются после успешного добавления клиента */
        startPage.open(customersTabLink);
        addCust.compareFirstNameValues();
        addCust.compareLastNameValues();
        addCust.comparePostCodeValues();
        addCust.compareAccountNumberValues();
    }
    @Test
    @DisplayName("CC-3, add customer to open account page")
    public void checkAddCustomerToOpenAccountPage() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        AddCust addCust = PageFactory.initElements(driver, AddCust.class);
        OpenAccount openAccount = PageFactory.initElements(driver, OpenAccount.class);

        startPage.open(addCustomerTabLink);
        addCust.fillFirstName();
        addCust.fillLastName();
        addCust.fillPostCode();
        addCust.clickAddCustomerBtn();
        addCust.getAlertMessage();
        addCust.confirmAction();
        startPage.open(openAccountTabLink);
        openAccount.clickCustomerSelect();
        openAccount.checkNewSelectOption();
    }
    @Test
    @DisplayName("CC-4, try add customer with empty data")
    public void checkAddCustomerWithAllEmptyData() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        AddCust addCust = PageFactory.initElements(driver, AddCust.class);

        startPage.open(addCustomerTabLink);
        addCust.clickAddCustomerBtn();
        addCust.checkFirstNameFieldFocus();
    }
    @Test
    @DisplayName("CC-5, try add customer with partially blank data")
    public void checkAddCustomerWithPartiallyBlankData() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        AddCust addCust = PageFactory.initElements(driver, AddCust.class);

        startPage.open(addCustomerTabLink);
        addCust.fillFirstName();
        addCust.clickAddCustomerBtn();
        addCust.checkLastNameFieldFocus();
    }
}
