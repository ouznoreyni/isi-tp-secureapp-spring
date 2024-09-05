package sn.ouznoreyni.secureappspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI SecureAppApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("SecureApp API")
                        .description("Application de gestion des utilisateurs")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Ousmane DIOP")
                                .email("ousmanediopp268@gmail.com")
                                .url("https://github.com/ouznoreyni"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
