package api.mykeycloak.domain;

import lombok.Builder;

@Builder
public record AuthKeycloak(String password, String clientId, String grantType, String username, String client_secret,
                           String access_token, int expires_in, int refresh_expires_in, String refresh_token,
                           String token_type, int not_before_policy, String session_state, String scope){}
