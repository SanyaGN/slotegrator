package api.actions;

import api.dto.GenerateTokenBodyDTO;
import api.dto.Specifications;
import api.dto.TokenParamsDTO;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static org.apache.http.HttpStatus.SC_OK;

public class CasinoPlayerActions {

    private static final String CASINO_SITE_HOST = "http://test-api.d6.dev.devcaz.com";
    private static final String GENERATE_TOKEN_URL = "/v2/oauth2/token";
    private static final String POST_CREATE_PLAYER_REQUEST_URL = "/v2/players";
    private static final String GET_PLAYER_REQUEST_URL = "/v2/players/{id}";

    private static final String BASIC_AUTH_USERNAME_PARAM = "front_2d6b0a8391742f5d789d7d915755e09e";
    private static final String BASIC_AUTH_PASSWORD_PARAM = "???????????";

    private final String PLAYER_ID_PARAM = "id";


    private ExtractableResponse<Response> response;
    private GenerateTokenBodyDTO getTokenCredentials;


    public TokenParamsDTO populateToken(GenerateTokenBodyDTO requestBody) {
        response =  Specifications.requestSpec(BASIC_AUTH_USERNAME_PARAM, BASIC_AUTH_PASSWORD_PARAM,
                        CASINO_SITE_HOST, GENERATE_TOKEN_URL)
                .body(requestBody)
                .when().post()
                .then().statusCode((SC_OK))
                .extract();
        return response.response().body().as(TokenParamsDTO.class);
    }
}
