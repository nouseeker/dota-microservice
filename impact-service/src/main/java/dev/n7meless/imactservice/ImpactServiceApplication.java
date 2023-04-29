package dev.n7meless.imactservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Impact API",
        version = "1.0",
        description = "Documentation Impact-Service v1.0",
        termsOfService = "n7meless",
        contact = @Contact(
                name = "Aidar Almuhametov",
                email = "n7meless@gmail.com",
                url = "github.com/n7meless")),
        servers = @Server(url = "/api/impact", description = "Default Server Url"))
public class ImpactServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpactServiceApplication.class, args);
    }

}
