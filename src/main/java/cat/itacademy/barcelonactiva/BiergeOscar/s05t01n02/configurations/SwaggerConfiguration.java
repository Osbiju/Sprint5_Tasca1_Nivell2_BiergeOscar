package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                .title("Documentacio exercici Sprint 5,Tasca 1, Nivell 2")
                .version("1.0")
                .description("Documentacio swagger de la api FLOR")
                .termsOfService("http://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
