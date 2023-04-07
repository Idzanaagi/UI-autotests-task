package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;

public class FindCustomerTests extends WebdriverSetting {

    @Test
    @DisplayName("FC-1, find by first name")
    public void findCustomersByFirstName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForFirstNameCheck();
        customers.getNumberOfItemsInCusrtomerTable(1);
        customers.compareFirstNameValue();
    }

    @Test
    @DisplayName("FC-2, find by last name")
    public void findCustomersByLastName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForLastNameCheck();
        customers.getNumberOfItemsInCusrtomerTable(1);
        customers.compareLastNameValue();
    }

    @Test
    @DisplayName("FC-3, find by post code")
    public void findCustomersByPostCode() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForPostCode();
        customers.getNumberOfItemsInCusrtomerTable(1);
        customers.comparePostCodeValue();
    }

    @Test
    @DisplayName("FC-4, find by account")
    public void findCustomersByAccountNumber() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForAccountNumber();
        customers.getNumberOfItemsInCusrtomerTable(1);
        customers.compareAccountNumberValue();
    }

    @Test
    @DisplayName("FC-5, find non-existed customer")
    public void findNonExistedCustomer() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.findNonExistentCustomer();
        customers.getNumberOfItemsInCusrtomerTable(0);
    }

    @Test
    @DisplayName("FC-6, find multiple customers")
    public void findMultipleCustomers() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomersFieldForMultipleSearch();
        customers.getNumberOfItemsInCusrtomerTable(2);
        customers.compareMultipleSearchValues();
    }
}
