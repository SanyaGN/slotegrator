package ui.steps;

import ui.actions.CasinoLoginPage;
import ui.actions.CasinoMainPage;
import ui.actions.CasinoPlayersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static ui.steps.TestClass.getWebDriver;

public class CasinoUISteps {

    private final WebDriver webDriver = getWebDriver();

    @Given("I open casino login page")
    public void openCasinoLoginPage() {
        new CasinoLoginPage(webDriver).openLoginPage();
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() {
        new CasinoLoginPage(webDriver).logInWithValidCredentials();
    }

    @Then("Casino main page is loaded")
    public void casinoMainPageIsLoaded() {
        new CasinoMainPage(webDriver).mainPageIsLoaded();
    }

    @Then("Players page is loaded")
    public void playersPageIsLoaded() {
        new CasinoPlayersPage(webDriver).playersPageIsLoaded();
    }

    @Then("I add valid parameter in search by name field")
    public void addParamInSearchByNameField() {
        new CasinoPlayersPage(webDriver).addValidDataInSearchByNameField();
    }

    @Then("I set random parameter in search by name field")
    public void setRandomParamInSearchByNameField() {
        new CasinoPlayersPage(webDriver).addRandomDataInSearchByNameField();
    }

    @Then("I click on link Users on side menu")
    public void clickOnLinkWithText() {
        new CasinoMainPage(webDriver).clickOnUsersSideMenu();
    }

    @Then("I click on link Players to open players page")
    public void clickToOpenPlayersPage() {
        new CasinoMainPage(webDriver).clickToOpenPlayersPage();
    }

    @Then("I verify that Player search result is not empty")
    public void verifyPlayerSearchResult() {
        new CasinoPlayersPage(webDriver).validateSearchResult();
    }

    @Then("I verify that Player search result is empty")
    public void verifyPlayerSearchResultIsEmpty() {
        new CasinoPlayersPage(webDriver).verifyThatSearchResultIsEmpty();
    }
}
