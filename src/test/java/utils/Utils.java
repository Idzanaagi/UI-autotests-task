package utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    WebDriver driver;
    public void fillField(WebElement el, String value) { el.sendKeys(value); }
    public void checkValue(WebElement el, String value) {
        Assertions.assertEquals(el.getText(), value);
    }
}
