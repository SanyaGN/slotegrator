package api.actions;

import api.dto.CreatePlayerBodyDTO;
import api.dto.CreatePlayerResponseDTO;
import api.dto.ErrorMessageDTO;
import api.dto.GenerateTokenBodyDTO;
import api.dto.TokenParamsDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;

public class CasinoPlayerActions {

    private static final String CASINO_SITE_HOST = "http://test-api.d6.dev.devcaz.com";
    private static final String GENERATE_TOKEN_URL = "/v2/oauth2/token";
    private static final String POST_CREATE_PLAYER_REQUEST_URL = "/v2/players";
    private static final String GET_PLAYER_REQUEST_URL = "/v2/players/{id}";

    private static final String BASIC_AUTH_USERNAME_PARAM = "front_2d6b0a8391742f5d789d7d915755e09e";
    private static final String BASIC_AUTH_PASSWORD_PARAM = "password";

    private final String PLAYER_ID_PARAM = "id";


    private ExtractableResponse<Response> response;


    public TokenParamsDTO populateToken(GenerateTokenBodyDTO requestBody) {
        response =  requestSpec()
                .auth().preemptive().basic(BASIC_AUTH_USERNAME_PARAM, BASIC_AUTH_PASSWORD_PARAM).request()
                .body(requestBody)
                .basePath(CasinoPlayerActions.GENERATE_TOKEN_URL).log().all()
                .when().post()
                .then().log().all()
                .statusCode((SC_OK))
                .extract();
        return response.response().body().as(TokenParamsDTO.class);
    }

    public TokenParamsDTO populateClientToken(GenerateTokenBodyDTO requestBody) {
        response =  requestSpec()
                .auth().preemptive().basic(BASIC_AUTH_USERNAME_PARAM, BASIC_AUTH_PASSWORD_PARAM).request()
                .body(requestBody)
                .basePath(CasinoPlayerActions.GENERATE_TOKEN_URL).log().all()
                .when().post()
                .then().log().all()
                .statusCode((SC_OK))
                .extract();
        return response.response().body().as(TokenParamsDTO.class);
    }

    public CreatePlayerResponseDTO createPlayer(String accessToken, CreatePlayerBodyDTO body) {
        response = requestSpec()
                .auth().oauth2(accessToken)
                .body(body)
                .basePath(CasinoPlayerActions.POST_CREATE_PLAYER_REQUEST_URL).log().all()
                .when().post()
                .then().log().all()
                .statusCode((SC_CREATED))
                .extract();
        return response.response().body().as(CreatePlayerResponseDTO.class);
    }

    public CreatePlayerResponseDTO getPlayer(String accessToken, Integer id) {
        response = requestSpec()
                .auth().oauth2(accessToken)
                .pathParam(PLAYER_ID_PARAM, id)
                .basePath(CasinoPlayerActions.GET_PLAYER_REQUEST_URL).log().all()
                .when().get()
                .then().log().all()
                .statusCode((SC_OK))
                .extract();
        return response.response().body().as(CreatePlayerResponseDTO.class);
    }

    public ErrorMessageDTO getInvalidPlayer(String accessToken) {
        int invalidId = 85947;
        response = requestSpec()
                .auth().oauth2(accessToken)
                .pathParam(PLAYER_ID_PARAM, invalidId)
                .basePath(CasinoPlayerActions.GET_PLAYER_REQUEST_URL).log().all()
                .when().get()
                .then().log().all()
                .statusCode((SC_NOT_FOUND))
                .extract();
        return response.response().body().as(ErrorMessageDTO.class);
    }

    private RequestSpecification requestSpec() {

        return given()
                .headers(CONTENT_TYPE, ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(CasinoPlayerActions.CASINO_SITE_HOST);
    }
}
