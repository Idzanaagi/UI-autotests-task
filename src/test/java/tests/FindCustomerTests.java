package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;
import utils.TestData;

public class FindCustomerTests extends WebdriverSetting {

    TestData testData = new TestData();

    @Test
    @DisplayName("FC-1, find by first name")
    public void findCustomersByFirstName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("ha");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), testData.harryName);
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
    }

    @Test
    @DisplayName("FC-2, find by last name")
    public void findCustomersByLastName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("lo");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), testData.nevilleName);
        Assertions.assertEquals(customers.getLastNameWithFilter(), testData.newvilleLastName);
    }

    @Test
    @DisplayName("FC-3, find by post code")
    public void findCustomersByPostCode() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("e7");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), testData.harryName);
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
    }

    @Test
    @DisplayName("FC-4, find by account")
    public void findCustomersByAccountNumber() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("1013");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getLastNameWithFilter(), testData.newvilleLastName);
        Assertions.assertEquals(customers.getAccountNumberWithFilter(), "1013 1014 1015");
    }

    @Test
    @DisplayName("FC-5, find non-existed customer")
    public void findNonExistedCustomer() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("dd");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 0);
    }

    @Test
    @DisplayName("FC-6, find multiple customers")
    public void findMultipleCustomers() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("ne");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 2);
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), testData.hermoineName);
        Assertions.assertEquals(customers.getLastNameWithFilter(), testData.hermoineLastName);
        Assertions.assertEquals(customers.getFirstNameOnLine2(), testData.nevilleName);
        Assertions.assertEquals(customers.getLastNameOnLine2(), testData.newvilleLastName);
    }
}
