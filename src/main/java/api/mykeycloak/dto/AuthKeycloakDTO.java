package api.mykeycloak.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;


@Builder
@JsonPropertyOrder({ "token_type", "expires_in", "access_token",
        "refresh_expires_in", "refresh_token", "session_state", "scope", "not_before_policy"})
public record AuthKeycloakDTO(String access_token, int expires_in, int refresh_expires_in, String refresh_token,
                              String token_type, int not_before_policy, String session_state, String scope){}
