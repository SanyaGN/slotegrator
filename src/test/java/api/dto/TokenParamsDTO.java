package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slotegrator.JsonAutoMappable;

@Data
public class TokenParamsDTO implements JsonAutoMappable {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private String expiresIn;
}
