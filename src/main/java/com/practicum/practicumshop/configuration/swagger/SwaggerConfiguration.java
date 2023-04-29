package com.practicum.practicumshop.configuration.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by ogbozoyan at 13.01.2023
 * github.com/ogbozoyan
 */
@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .info(springDocapiInfo())
                .security(List.of(new SecurityRequirement()));

    }

    Info springDocapiInfo() {
        return new Info()
                .title("Backend for shop practicum")
                .description("Java >>>>> Go")
                .version("1.0.0");
    }

}
