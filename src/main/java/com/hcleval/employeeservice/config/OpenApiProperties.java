package com.hcleval.employeeservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app.openapi")
public class OpenApiProperties {
    private String title;

    private String description;

    private String version;

    private Contact contact = new Contact();

    private License license = new License();

    private Server server = new Server();

    @Getter
    @Setter
    public static class Contact {
        private String name;
        private String email;
    }

    @Getter
    @Setter
    public static class License {
        private String name;
        private String url;
    }

    @Getter
    @Setter
    public static class Server {
        private String url;
        private String description;
    }
}
