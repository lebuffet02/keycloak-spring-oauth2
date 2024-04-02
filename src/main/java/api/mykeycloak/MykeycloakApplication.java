package api.mykeycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MykeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(MykeycloakApplication.class, args);
	}
}
