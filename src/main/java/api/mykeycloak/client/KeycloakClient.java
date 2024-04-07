package api.mykeycloak.client;

import api.mykeycloak.domain.AuthKeycloak;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${application.name}", url = "${url.generate.token}")
public interface KeycloakClient {

    @PostMapping(headers = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    AuthKeycloak getDadosKeycloak(@RequestBody Object auth);
}
