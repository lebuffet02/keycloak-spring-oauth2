package api.mykeycloak.service;

import api.mykeycloak.client.KeycloakClient;
import api.mykeycloak.domain.AuthKeycloak;
import api.mykeycloak.domain.RefreshKeycloak;
import api.mykeycloak.dto.AuthKeycloakDTO;
import api.mykeycloak.mapper.MapperAuthKeycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    KeycloakClient client;
    @Autowired
    MapperAuthKeycloak mapper;


    public AuthKeycloakDTO tokenService(AuthKeycloak authKeycloak) {
        return mapper.builderToAuthKeycloakDTO(getChamadaFeign(authKeycloak));
    }

    public AuthKeycloakDTO refreshTokenService(RefreshKeycloak refresh) {
        return mapper.builderToAuthKeycloakDTO(getChamadaFeign(refresh));
    }

    private AuthKeycloak getChamadaFeign(Object obj) {
        if (obj instanceof AuthKeycloak authKeycloak) {
            AuthKeycloak auth = client.getDadosKeycloak(getFormTokenData(authKeycloak));
            Objects.requireNonNull(auth);
            return auth;
        }
        RefreshKeycloak refKeycloak = (RefreshKeycloak) obj;
        AuthKeycloak refresh = client.getDadosKeycloak(getFormRefreshData(refKeycloak));
        Objects.requireNonNull(refresh);
        return refresh;
    }

    private MultiValueMap<String, String> getFormTokenData(AuthKeycloak auth) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", auth.clientId());
        formData.add("username", auth.username());
        formData.add("password", auth.password());
        formData.add("grant_type", auth.grantType());
        return formData;
    }

    private MultiValueMap<String, String> getFormRefreshData(RefreshKeycloak refresh) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", refresh.clientId());
        formData.add("refresh_token", refresh.refresh_token());
        formData.add("grant_type", "refresh_token");
        return formData;
    }
}