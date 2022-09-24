package api.dto;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.netty.channel.unix.Errors;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorMessageDTO {

    private List<Errors> errors;

    private String name;
    private String message;
    private String code;
    private String status;
}
