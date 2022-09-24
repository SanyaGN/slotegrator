package api.dto;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GenerateTokenBodyDTO {

    private String scope;
    private String username;
    private String password;
    private String grandType;
}
