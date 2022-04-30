package com.accure.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "Authorization Bearer Token";

    @Bean
    public OpenAPI openAPIConfiguration() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
                                                                        .name(SECURITY_SCHEME_NAME)
                                                                        .type(SecurityScheme.Type.HTTP)
                                                                        .scheme("bearer")
                                                                        .bearerFormat("JWT"))
                                ).info(new Info()
                                        .title("Accure API Endpoints")
                                        .version("1.0.0")
                                        .description("Accure REST endpoints")
                                ).externalDocs(new io.swagger.v3.oas.models.ExternalDocumentation()
                                        .description("Repository")
                                        .url("https://github.com/JeanHSuarez/accure"));
    }
}
