package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slotegrator.JsonAutoMappable;

@Data
public class CreatePlayerResponseDTO implements JsonAutoMappable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("country_id")
    private Object countryId;

    @JsonProperty("timezone_id")
    private Object timezoneId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("gender")
    private Object gender;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("birthdate")
    private Object birthdate;

    @JsonProperty("bonuses_allowed")
    private Boolean bonusesAllowed;

    @JsonProperty("is_verified")
    private Boolean isVerified;
}
