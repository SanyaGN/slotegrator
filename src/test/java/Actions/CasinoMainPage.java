package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasinoMainPage {

    private final WebDriver driver;

    private static final String MAIN_PAGE_HEADER_LOGO = "//img[@id='header-logo']";
    private static final String USERS_MAIN_SIDE_MENU = "//a[@data-target ='#s-menu-users']";
    private static final String PLAYERS_LINK_IN_USERS_MENU = "//*[@href='/user/player/admin' and contains(text(), 'Players')]";

    public CasinoMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void mainPageIsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(MAIN_PAGE_HEADER_LOGO)));
    }

    public void clickOnUsersSideMenu() {
        driver.findElement(By.xpath(USERS_MAIN_SIDE_MENU)).click();
    }

    public void clickToOpenPlayersPage() {
        driver.findElement(By.xpath(PLAYERS_LINK_IN_USERS_MENU)).click();
    }
}
