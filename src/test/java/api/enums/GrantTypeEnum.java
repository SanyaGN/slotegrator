package api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GrantTypeEnum {
    CLIENT_CREDENTIALS("client_credentials"),
    PASSWORD("password");
    private final String grantType;
}
