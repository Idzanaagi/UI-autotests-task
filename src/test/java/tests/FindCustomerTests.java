package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FindCustomerTests extends WebdriverSetting {

    Properties appProps = new Properties();

    private final String harryName;
    private final String nevilleName;
    private final String nevilleLastName;
    private final String hermoineName;
    private final String hermoineLastName;

    {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/data.properties");
            appProps.load(fis);

            harryName = appProps.getProperty("harryName");
            nevilleName = appProps.getProperty("nevilleName");
            nevilleLastName = appProps.getProperty("nevilleLastName");
            hermoineName = appProps.getProperty("hermoineName");
            hermoineLastName = appProps.getProperty("hermoineLastName");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("FC-1, find by first name")
    @Description("FC-1, check if the search by first name works correctly")
    public void findCustomersByFirstName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("ha");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), harryName );
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
    }

    @Test
    @DisplayName("FC-2, find by last name")
    @Description("FC-2, check if the search by last name works correctly")
    public void findCustomersByLastName() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("lo");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), nevilleName);
        Assertions.assertEquals(customers.getLastNameWithFilter(), nevilleLastName);
    }

    @Test
    @DisplayName("FC-3, find by post code")
    @Description("FC-3, check if the search by post code works correctly")
    public void findCustomersByPostCode() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("e7");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getFirstNameWithFilter(), harryName);
        Assertions.assertEquals(customers.getPostCodeWithFilter(), "E725JB");
    }

    @Test
    @DisplayName("FC-4, find by account")
    @Description("FC-4, check if the search by account number works correctly")
    public void findCustomersByAccountNumber() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("1013");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 1);
        Assertions.assertEquals(customers.getLastNameWithFilter(), nevilleLastName);
        Assertions.assertEquals(customers.getAccountNumberWithFilter(), "1013 1014 1015");
    }

    @Test
    @DisplayName("FC-5, find non-existed customer")
    @Description("FC-5, check if the search by non-existed customer works correctly")
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
    @Description("FC-5, check the correctness of the search of several clients")
    public void findMultipleCustomers() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.clickSearchCustomersField();
        customers.fillSearchCustomerField("ne");
        Assertions.assertEquals(customers.getSizeAllElementsInCustomerTable(), 2);
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), hermoineName);
        Assertions.assertEquals(customers.getLastNameWithFilter(), hermoineLastName);
        Assertions.assertEquals(customers.getFirstNameOnLine2(), nevilleName);
        Assertions.assertEquals(customers.getLastNameOnLine2(), nevilleLastName);
    }
}
