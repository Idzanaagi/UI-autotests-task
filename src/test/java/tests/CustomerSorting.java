package tests;

import utils.WebdriverSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.StartPage;
import pages.Customers;


public class CustomerSorting extends WebdriverSetting {

    private final String customersTabLink = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";

    @Test
    @DisplayName("CS-1, sort in descending order")
    public void sortCustomersInDescendingOrder() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.sortByFirstName();
        customers.compareFirstElInDescendingOrder();
        customers.compareMiddleElInDescendingOrder();
        customers.compareLastElInDescendingOrder();
    }

    @Test
    @DisplayName("CS-2, sort in ascending order")
    public void sortCustomersInAscendingOrder() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        startPage.open(customersTabLink);
        customers.sortByFirstName();
        customers.sortByFirstName();
        customers.compareFirstElInAscendingOrder();
        customers.compareMiddleElInAscendingOrder();
        customers.compareLastElInAscendingOrder();
    }
}
