package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slotegrator.JsonAutoMappable;

@Data
public class ErrorMessageDTO implements JsonAutoMappable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("field")
    private String field;

    @JsonProperty("message")
    private String message;

    @JsonProperty("code")
    private String code;

    @JsonProperty("status")
    private String status;
}
