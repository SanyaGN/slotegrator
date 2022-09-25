package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.slotegrator.JsonAutoMappable;

@Data
@Accessors(chain = true)
public class CreatePlayerBodyDTO implements JsonAutoMappable {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password_change")
    private String passwordChange;

    @JsonProperty("password_repeat")
    private String passwordRepeat;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
