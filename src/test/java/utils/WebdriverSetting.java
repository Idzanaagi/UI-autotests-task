package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * The type Webdriver setting.
 */
public class WebdriverSetting {

    /**
     * The Driver.
     */
    private WebDriver driver;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        final int implicitlyWaitTime = 10;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile());
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
    }

    /**
     * Close.
     */
    @AfterEach
    public void close() {
        driver.quit();
    }

    /**
     * Gets driver.
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }

}
