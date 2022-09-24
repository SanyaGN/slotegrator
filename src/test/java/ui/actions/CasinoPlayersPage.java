package ui.actions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasinoPlayersPage {

    private final WebDriver webDriver;

    private static final String PLAYERS_PAGE_HEADER_LOGO = "//div[@class='panel-heading']";
    private static final String SEARCH_BY_NAME_FIELD = "//input[@name = 'PlayerSearch[name]']";
    private static final String NO_RESULT_TEXT = "//span[contains(text(), 'No results found')]";
    private static final String PLAYER_NAME_PARAM = "Guy";

    public CasinoPlayersPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void playersPageIsLoaded() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(PLAYERS_PAGE_HEADER_LOGO)));
    }

    public void addValidDataInSearchByNameField() {
        webDriver.findElement(By.xpath(SEARCH_BY_NAME_FIELD))
                .sendKeys(PLAYER_NAME_PARAM, Keys.ENTER);
    }

    public void addRandomDataInSearchByNameField() {
        String randomName = RandomStringUtils.randomAlphabetic(12);
        webDriver.findElement(By.xpath(SEARCH_BY_NAME_FIELD))
                .sendKeys(randomName, Keys.ENTER);
    }

    public void validateSearchResult() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions
                .invisibilityOfElementWithText(By.xpath(NO_RESULT_TEXT), NO_RESULT_TEXT));
    }

    public void verifyThatSearchResultIsEmpty() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(NO_RESULT_TEXT)));
    }
}
