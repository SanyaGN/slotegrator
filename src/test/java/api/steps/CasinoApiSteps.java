package api.steps;

import api.actions.CasinoPlayerActions;
import api.dto.GenerateTokenBodyDTO;
import api.enums.TokenTypeEnum;
import io.cucumber.java.en.Given;

public class CasinoApiSteps {

    private CasinoPlayerActions actions;
    private GenerateTokenBodyDTO tokenBodyConstructor;

    private static final String SCOPE_PARAM = "guest:default";
    private static final String GRAND_TYPE_PARAM = "client_credentials";

    @Given("I populate {}")
    public void populateToken(TokenTypeEnum tokenType) {
        switch (tokenType) {
            case ACCESS_TOKEN:
                actions.populateToken(tokenBodyConstructor);
                break;
        }
    }

    @Given("I generate token request body")
    public void generateTokenBody() {
        tokenBodyConstructor = new GenerateTokenBodyDTO().setGrandType(GRAND_TYPE_PARAM)
                .setScope(SCOPE_PARAM);
    }
}
