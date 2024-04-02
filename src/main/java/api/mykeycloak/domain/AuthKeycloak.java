package api.mykeycloak.domain;

public record AuthKeycloak(String password, String clientId, String grantType, String username) {}
