package Steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestClass {

    public static WebDriver driver;

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C://Drivers//chromedriver.exe";

    public static WebDriver getWebDriver() {
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
