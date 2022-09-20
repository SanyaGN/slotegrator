package Steps;

import Actions.CasinoLoginPage;
import Actions.CasinoMainPage;
import Actions.CasinoPlayersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static Steps.TestClass.getWebDriver;

public class CasinoUISteps {

    private final WebDriver driver = getWebDriver();

    @Given("I open casino login page")
    public void openCasinoLoginPage() {
        new CasinoLoginPage(driver).openLoginPage();
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() {
        new CasinoLoginPage(driver).logInWithValidCredentials();
    }

    @Then("Casino main page is loaded")
    public void casinoMainPageIsLoaded() {
        new CasinoMainPage(driver).mainPageIsLoaded();
    }

    @Then("Players page is loaded")
    public void playersPageIsLoaded() {
        new CasinoPlayersPage(driver).playersPageIsLoaded();
    }

    @Then("I add valid parameter in search by name field")
    public void addParamInSearchByNameField() {
        new CasinoPlayersPage(driver).addValidDataInSearchByNameField();
    }

    @Then("I set random parameter in search by name field")
    public void setRandomParamInSearchByNameField() {
        new CasinoPlayersPage(driver).addRandomDataInSearchByNameField();
    }

    @Then("I click on link Users on side menu")
    public void clickOnLinkWithText() {
        new CasinoMainPage(driver).clickOnUsersSideMenu();
    }

    @Then("I click on link Players to open players page")
    public void clickToOpenPlayersPage() {
        new CasinoMainPage(driver).clickToOpenPlayersPage();
    }

    @Then("I verify that Player search result is not empty")
    public void verifyPlayerSearchResult() {
        new CasinoPlayersPage(driver).validateSearchResult();
    }

    @Then("I verify that Player search result is empty")
    public void verifyPlayerSearchResultIsEmpty() {
        new CasinoPlayersPage(driver).verifyThatSearchResultIsEmpty();
    }
}
