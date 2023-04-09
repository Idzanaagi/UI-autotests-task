package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;
import utils.TestData;

public class CustomerSortingTests extends WebdriverSetting {

    TestData testData = new TestData();

    @Test
    @DisplayName("CS-1, sort in descending order")
    @Description("CS-1, check the sorting of clients by First Name in descending order")
    public void sortCustomersInDescendingOrder() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.sortByFirstName();
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), testData.ronName);
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), testData.hermoineName);
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), testData.albusName);
    }

    @Test
    @DisplayName("CS-2, sort in ascending order")
    @Description("CS-2, check the sorting of clients by First Name in ascending order")
    public void sortCustomersInAscendingOrder() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.sortByFirstName();
        customers.sortByFirstName();
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), testData.albusName);
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), testData.hermoineName);
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), testData.ronName);
    }
}
