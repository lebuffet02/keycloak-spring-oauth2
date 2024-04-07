package api.mykeycloak.controller;

import api.mykeycloak.client.KeycloakClient;
import api.mykeycloak.domain.AuthKeycloak;
import api.mykeycloak.dto.AuthKeycloakDTO;
import api.mykeycloak.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    KeycloakClient client;
    @Autowired
    AuthService service;


    @PostMapping("/token")
    public ResponseEntity<AuthKeycloakDTO> token(@RequestBody AuthKeycloak authKeycloak) {
        AuthKeycloakDTO authDTO = service.tokenService(authKeycloak);
        return ResponseEntity.ok(authDTO);
    }
}