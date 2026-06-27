package com.hcleval.employeeservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {
    private final OpenApiProperties properties;
    @Bean
    public OpenAPI employeeServiceOpenAPI() {

        Server server = new Server()
                .url(properties.getServer().getUrl())
                .description(properties.getServer().getDescription());

        Contact contact = new Contact()
                .name(properties.getContact().getName())
                .email(properties.getContact().getEmail());

        License license = new License()
                .name(properties.getLicense().getName())
                .url(properties.getLicense().getUrl());

        Info info = new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("GitHub Repository")
                                .url("https://github.com/madhusk093")
                );
    }
}
