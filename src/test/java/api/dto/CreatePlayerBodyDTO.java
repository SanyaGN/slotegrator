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
public class CreatePlayerBodyDTO {

    private String username;
    private String passwordChange;
    private String passwordRepeat;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
}
