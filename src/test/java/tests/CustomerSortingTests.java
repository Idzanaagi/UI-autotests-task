package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.CustomersPage;
import pages.StartPage;
import utils.WebdriverSetting;

import static utils.DataProperties.readProperty;

/**
 * The type Customer sorting tests.
 */
public class CustomerSortingTests extends WebdriverSetting {

    /**
     * Sort customers in descending order.
     */
    @Test
    @DisplayName("CS-1, sort in descending order")
    @Description("CS-1, check the sorting of clients by First Name in descending order")
    public void sortCustomersInDescendingOrder() {
        StartPage startPage = new StartPage(getDriver());
        CustomersPage customers = new CustomersPage(getDriver());
        startPage.openCustomersTab();
        customers.sortByFirstName();
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), readProperty("ronName"));
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), readProperty("hermoineName"));
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), readProperty("albusName"));
    }

    /**
     * Sort customers in ascending order.
     */
    @Test
    @DisplayName("CS-2, sort in ascending order")
    @Description("CS-2, check the sorting of clients by First Name in ascending order")
    public void sortCustomersInAscendingOrder() {
        StartPage startPage = new StartPage(getDriver());
        CustomersPage customers = new CustomersPage(getDriver());
        startPage.openCustomersTab();
        customers.sortByFirstName();
        customers.sortByFirstName();
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), readProperty("albusName"));
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), readProperty("hermoineName"));
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), readProperty("ronName"));
    }
}
