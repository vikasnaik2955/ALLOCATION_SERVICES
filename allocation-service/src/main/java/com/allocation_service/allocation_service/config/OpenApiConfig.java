package com.allocation_service.allocation_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI donorFoodServiceOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Allocation Service API")
                        .description("APIs for managing food donors and donations")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("DFS Team")
                                .email("support@dfs.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                );
    }
}

