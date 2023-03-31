package tests;

import utils.WebdriverSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.Customers;
import pages.StartPage;

public class FindCustomer extends WebdriverSetting {

    private final String customersTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";

    @Test
    @DisplayName("FC-1, find by first name")
    public void findCustomersByFirstName() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForFirstNameCheck();
        customers.compareFirstNameValue();
    }
    @Test
    @DisplayName("FC-2, find by last name")
    public void findCustomersByLastName() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForLastNameCheck();
        customers.compareLastNameValue();
    }
    @Test
    @DisplayName("FC-3, find by post code")
    public void findCustomersByPostCode() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForPostCode();
        customers.comparePostCodeValue();
    }
    @Test
    @DisplayName("FC-4, find by account")
    public void findCustomersByAccountNumber() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForAccountNumber();
        customers.compareAccountNumberValue();
    }
    @Test
    @DisplayName("FC-5, find non-existed customer")
    public void findNonExistedCustomer() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.findNonExistentCustomer();
        customers.getCountEl();
    }
    @Test
    @DisplayName("FC-6, find multiple customers")
    public void findMultipleCustomers() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForMultipleSearch();
        customers.compareMultipleSearchValue();
    }
}
