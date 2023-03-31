package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    private WebElement addCustomerBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    private WebElement openAccountBtn;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
    private WebElement customersBtn;

    public void open(String link) {driver.get(link); }
}
