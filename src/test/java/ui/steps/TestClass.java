package ui.steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestClass {

    public static WebDriver webDriver;

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C://Drivers//chromedriver.exe";

    public static WebDriver getWebDriver() {
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webDriver;
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
