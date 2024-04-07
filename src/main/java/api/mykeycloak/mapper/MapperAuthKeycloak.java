package api.mykeycloak.mapper;

import api.mykeycloak.domain.AuthKeycloak;
import api.mykeycloak.dto.AuthKeycloakDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperAuthKeycloak {

    public AuthKeycloakDTO builderToAuthKeycloakDTO(AuthKeycloak authKeycloak) {
        return AuthKeycloakDTO.builder()
                .access_token(authKeycloak.access_token())
                .refresh_token(authKeycloak.refresh_token())
                .token_type(authKeycloak.token_type())
                .not_before_policy(authKeycloak.not_before_policy())
                .expires_in(authKeycloak.expires_in())
                .refresh_expires_in(authKeycloak.refresh_expires_in())
                .session_state(authKeycloak.session_state())
                .not_before_policy(authKeycloak.not_before_policy())
                .scope(authKeycloak.scope())
                .build();
    }
}
