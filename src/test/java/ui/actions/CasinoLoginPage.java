package ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CasinoLoginPage {

    private final WebDriver webDriver;

    private static final String SIGN_IN_BUTTON = "//input[@value='Sign in']";
    private static final String USER_NAME = "//*[@id='UserLogin_username']";
    private static final String PASSWORD = "//*[@id='UserLogin_password']";

    private static final String LOGIN_PARAM = "admin1";
    private static final String LOGIN_PAGE_URL = "http://test-app.d6.dev.devcaz.com/admin/login";
    private static final String PASSWORD_PARAM = "[9k<k8^z!+$$GkuP";

    public CasinoLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void logInWithValidCredentials() {
        webDriver.findElement(By.xpath(USER_NAME)).sendKeys(LOGIN_PARAM);
        webDriver.findElement(By.xpath(PASSWORD)).sendKeys(PASSWORD_PARAM);
        webDriver.findElement(By.xpath(SIGN_IN_BUTTON)).click();
    }

    public void openLoginPage() {
        webDriver.get(LOGIN_PAGE_URL);
    }
}
