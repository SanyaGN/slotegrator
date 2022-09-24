package api.dto;

import groovy.util.logging.Log4j2;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Log4j2
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatePlayerResponseDTO {

    private Integer id;
    private Object countryId;
    private Object timezoneId;
    private String username;
    private String email;
    private String name;
    private String surname;
    private Object gender;
    private String phoneNumber;
    private Object birthdate;
    private Boolean bonusesAllowed;
    private Boolean isVerified;
}
