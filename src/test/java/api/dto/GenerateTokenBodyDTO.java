package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slotegrator.JsonAutoMappable;

@Data
@Accessors(chain = true)
public class GenerateTokenBodyDTO implements JsonAutoMappable {

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("grant_type")
    private String grantType;
}
