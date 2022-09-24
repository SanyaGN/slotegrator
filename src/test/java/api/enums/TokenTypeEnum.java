package api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenTypeEnum {

    ACCESS_TOKEN,
    CLIENT_ACCESS_TOKEN,
    INVALID_TOKEN
}
