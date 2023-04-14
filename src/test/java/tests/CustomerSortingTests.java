package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import pages.Customers;
import pages.StartPage;
import utils.WebdriverSetting;

public class CustomerSortingTests extends WebdriverSetting {

    Properties appProps = new Properties();

    private final String hermoineName;
    private final String albusName;
    private final String ronName;

    {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/data.properties");
            appProps.load(fis);

            albusName = appProps.getProperty("albusName");
            hermoineName = appProps.getProperty("hermoineName");
            ronName = appProps.getProperty("ronName");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("CS-1, sort in descending order")
    @Description("CS-1, check the sorting of clients by First Name in descending order")
    public void sortCustomersInDescendingOrder() {

        StartPage startPage = new StartPage(driver);
        Customers customers = new Customers(driver);

        startPage.openCustomersTab();
        customers.sortByFirstName();
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), ronName);
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), hermoineName);
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), albusName);
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
        Assertions.assertEquals(customers.getFirstElementInTableColumnValue(), albusName);
        Assertions.assertEquals(customers.getMiddleElementInTableColumnValue(), hermoineName);
        Assertions.assertEquals(customers.getLastElementInTableColumnValue(), ronName);
    }
}
