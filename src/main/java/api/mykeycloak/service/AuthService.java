package api.mykeycloak.service;

import api.mykeycloak.client.KeycloakClient;
import api.mykeycloak.domain.AuthKeycloak;
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
        AuthKeycloak auth = client.getDadosKeycloak(getFormData(authKeycloak));
        Objects.requireNonNull(auth);
        return mapper.builderToAuthKeycloakDTO(auth);
    }

    private MultiValueMap<String, String> getFormData(AuthKeycloak auth) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", auth.clientId());
        formData.add("username", auth.username());
        formData.add("password", auth.password());
        formData.add("grant_type", auth.grantType());
        return formData;
    }
}