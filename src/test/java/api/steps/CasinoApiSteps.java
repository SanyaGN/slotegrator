package api.steps;

import api.actions.CasinoPlayerActions;
import api.dto.CreatePlayerBodyDTO;
import api.dto.CreatePlayerResponseDTO;
import api.dto.ErrorMessageDTO;
import api.dto.GenerateTokenBodyDTO;
import api.dto.TokenParamsDTO;
import api.enums.TokenTypeEnum;
import io.bloco.faker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import static api.enums.GrantTypeEnum.CLIENT_CREDENTIALS;
import static api.enums.GrantTypeEnum.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

public class CasinoApiSteps {

    private GenerateTokenBodyDTO tokenBody;
    private GenerateTokenBodyDTO clientTokenBody;
    private TokenParamsDTO getToken;
    private TokenParamsDTO getClientToken;
    private CreatePlayerBodyDTO createPlayerBody;
    private CreatePlayerResponseDTO createPlayerResponse;
    private CreatePlayerResponseDTO getPlayerResponse;
    private ErrorMessageDTO error;

    private static final String SCOPE_PARAM = "guest:default";

    @Given("I populate {}")
    public void populateToken(TokenTypeEnum tokenType) {
        switch (tokenType) {
            case ACCESS_TOKEN:
                assertThat(tokenBody).as("token body is not null").isNotNull();
                getToken = new CasinoPlayerActions().populateToken(tokenBody);
                break;

            case CLIENT_ACCESS_TOKEN:
                assertThat(clientTokenBody).as("token body is not null").isNotNull();
                getClientToken = new CasinoPlayerActions().populateClientToken(clientTokenBody);
        }
    }

    @Given("I generate token request body")
    public void generateTokenBody() {
        tokenBody = new GenerateTokenBodyDTO().setGrantType(CLIENT_CREDENTIALS.getGrantType())
                .setScope(SCOPE_PARAM);
    }

    @Given("I generate client token request body")
    public void generateClientTokenBody() {
        assertThat(createPlayerBody).as("body is not null").isNotNull();
        clientTokenBody = new GenerateTokenBodyDTO().setGrantType(PASSWORD.getGrantType())
                .setUsername(createPlayerBody.getUsername())
                .setPassword(createPlayerBody.getPasswordChange());
    }

    @Given("I generate create player request body")
    public void playerRequestBody() {
        Faker faker = new Faker();
        String password = RandomStringUtils.randomAlphabetic(13) + "==";
        createPlayerBody = new CreatePlayerBodyDTO().setUsername(RandomStringUtils.randomAlphabetic(7))
                .setPasswordChange(password)
                .setPasswordRepeat(password)
                .setEmail(faker.internet.email())
                .setName(faker.name.firstName())
                .setSurname(faker.name.lastName());
    }

    @When("I send POST create player request")
    public void sendCreatePlayerRequest() {
        assertThat(createPlayerBody).as("body is not null").isNotNull();
        createPlayerResponse = new CasinoPlayerActions()
                .createPlayer(getToken.getAccessToken(), createPlayerBody);
    }

    @And("I send GET player request by ID")
    public void sendGetPlayerByIdRequest() {
        assertThat(createPlayerResponse).as("create player response is not null").isNotNull();
        getPlayerResponse = new CasinoPlayerActions()
                .getPlayer(getClientToken.getAccessToken(), createPlayerResponse.getId());
    }

    @And("I send GET player request by different ID")
    public void sendGetPlayerByDifferentIdRequest() {
        error = new CasinoPlayerActions()
                .getInvalidPlayer(getClientToken.getAccessToken());
    }

    @Then("I validate get player response")
    public void iValidateGetPlayerResponse() {
        assertThat(getPlayerResponse).as("get player response is not null").isNotNull();
        assertThat(createPlayerResponse.getId())
                .as("compared id from createPlayer response and getPlayerResponse should be equal")
                .isEqualTo(getPlayerResponse.getId());
    }

    @Then("I should get {string} error message")
    public void shouldGetErrorMessage(String message) {
        assertThat(error).as("error response is not null").isNotNull();
        assertThat(error.getMessage()).as("message should be the same").contains(message);
    }
}
