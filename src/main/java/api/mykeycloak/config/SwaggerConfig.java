package api.mykeycloak.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
                name = "Apache 2.0")),
        security = {
                @SecurityRequirement(
                        name = "accessToken")
        }
)
public class SwaggerConfig implements WebMvcConfigurer{}
