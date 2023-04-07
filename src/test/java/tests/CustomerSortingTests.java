package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;

public class CustomerSortingTests extends WebdriverSetting {

    @Test
    @DisplayName("CS-1, sort in descending order")
    public void sortCustomersInDescendingOrder() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.sortByFirstName();
        customers.compareFirstElInDescendingOrder();
        customers.compareMiddleElInAscendingOrder();
        customers.compareLastElInDescendingOrder();
    }

    @Test
    @DisplayName("CS-2, sort in ascending order")
    public void sortCustomersInAscendingOrder() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.sortByFirstName();
        customers.sortByFirstName();
        customers.compareFirstElInAscendingOrder();
        customers.compareMiddleElInAscendingOrder();
        customers.compareLastElInAscendingOrder();
    }
}
