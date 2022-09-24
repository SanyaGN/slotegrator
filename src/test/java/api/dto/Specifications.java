package api.dto;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.google.common.net.HttpHeaders.CONTENT_TYPE;
import static io.restassured.RestAssured.given;

public class Specifications {

    public static RequestSpecification requestSpec(String username, String password, String uri, String path) {
       // String BASIC_AUTHORIZATION_PARAM = "Basic ZnJvbnRfMmQ2YjBhODM5MTc0MmY1ZDc4OWQ3ZDkxNTc1NWUwOWU6UEBzc3dvcmQyMg==";

        return given()
                .auth().basic(username, password)
                .headers(CONTENT_TYPE, ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(uri)
                .basePath(path)
                .request();
    }

    public static RequestSpecification requestSpec(String accessToken, String uri, String path) {
        return given()
                .auth().oauth2(accessToken)
                .headers(CONTENT_TYPE, ContentType.JSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(uri)
                .basePath(path)
                .request();
    }

}
