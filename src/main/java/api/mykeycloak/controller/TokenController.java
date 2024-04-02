package api.mykeycloak.controller;

import api.mykeycloak.domain.AuthKeycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/token")
@RestController
public class TokenController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<?> token(@RequestBody AuthKeycloak auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(getFormData(auth), headers);
        return restTemplate.postForEntity("http://localhost:8080/realms/realm/protocol/openid-connect/token", entity, String.class);
    }

    private  MultiValueMap<String, String> getFormData(AuthKeycloak auth) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", auth.clientId());
        formData.add("username", auth.username());
        formData.add("password", auth.password());
        formData.add("grant_type", auth.grantType());
        return formData;
    }
}
