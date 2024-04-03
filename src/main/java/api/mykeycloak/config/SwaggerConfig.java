package api.mykeycloak.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Keycloak",
        description = "Autenticação com o Keycloak",
        version = "1.0",
        contact = @Contact(
                name = "Lucas Buffet",
                email = "lebuffet02@gmail.com"
        ),
        license = @License(
                name = "Apache 2.0")), externalDocs = @ExternalDocumentation(url = "https://github.com/lebuffet02/keycloak-spring-oauth2"),
        servers = @Server(url = "${server.port}", description = "porta alterada"),
        security = {
                @SecurityRequirement(
                        name = "accessToken")
        }
)
public class SwaggerConfig implements WebMvcConfigurer{}
