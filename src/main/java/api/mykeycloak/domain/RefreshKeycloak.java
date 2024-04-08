package api.mykeycloak.domain;

import lombok.Builder;

@Builder
public record RefreshKeycloak(String clientId, String refresh_token){}
