package tests;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), "Harry");
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
    }

    @Test
    @DisplayName("FC-2, find by last name")
    public void findCustomersByLastName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForLastNameCheck();
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), "Neville");
        Assertions.assertEquals(customers.getLastNameWithFilter(), "Longbottom");
    }

    @Test
    @DisplayName("FC-3, find by post code")
    public void findCustomersByPostCode() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForPostCode();
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
        Assertions.assertEquals(customers.getFirstNameWithFilter(), "Harry");
    }

    @Test
    @DisplayName("FC-4, find by account")
    public void findCustomersByAccountNumber() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerFieldForAccountNumber();
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getAccountNumberWithFilter(), "1013 1014 1015");
        Assertions.assertEquals(customers.getLastNameWithFilter(), "Longbottom");
    }

    @Test
    @DisplayName("FC-5, find non-existed customer")
    public void findNonExistedCustomer() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.findNonExistentCustomer();
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 0);
    }

    @Test
    @DisplayName("FC-6, find multiple customers")
    public void findMultipleCustomers() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomersFieldForMultipleSearch();
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 2);
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), "Hermoine");
        Assertions.assertEquals(customers.getLastNameWithFilter(), "Granger");
        Assertions.assertEquals(customers.getFirstNameOnLine2(), "Neville");
        Assertions.assertEquals(customers.getLastNameOnLine2(), "Longbottom");
    }
}
