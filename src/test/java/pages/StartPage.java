package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StartPage {

    WebDriver driver;

    Properties appProps = new Properties();

    private final String addCustomerTabLink;
    private final String customersTabLink;
    private final String openAccountTabLink;

    {
        try {
            FileInputStream fis = new FileInputStream("src/test/java/resources/data.properties");
            appProps.load(fis);

            addCustomerTabLink = appProps.getProperty("addCustomerTabLink");
            customersTabLink = appProps.getProperty("customersTabLink");
            openAccountTabLink = appProps.getProperty("openAccountTabLink");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open the add customers tab")
    public void openAddCustomerTab() {
        driver.get(addCustomerTabLink);
    }
    @Step("Open the customers tab")
    public void openCustomersTab() {
        driver.get(customersTabLink);
    }
    @Step("Open the open account tab")
    public void openAccountTab() {
        driver.get(openAccountTabLink);
    }
}
