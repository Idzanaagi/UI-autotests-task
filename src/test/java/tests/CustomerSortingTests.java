package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;

public class CustomerSortingTests extends WebdriverSetting {
    private final String customersTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";

    @Test
    @DisplayName("CS-1, sort in descending order")
    public void sortCustomersInDescendingOrder() {
        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.open(customersTabLink);
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

        startPage.open(customersTabLink);
        customers.sortByFirstName();
        customers.sortByFirstName();
        customers.compareFirstElInAscendingOrder();
        customers.compareMiddleElInAscendingOrder();
        customers.compareLastElInAscendingOrder();
    }
}
