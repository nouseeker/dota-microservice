package dev.n7meless.farmservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Farm API",
        version = "1.0",
        description = "Documentation Farm-Service v1.0",
        termsOfService = "n7meless",
        contact = @Contact(
                name = "Aidar Almuhametov",
                email = "n7meless@gmail.com",
                url = "github.com/n7meless")),
        servers = @Server(url = "/", description = "Default Server Url"))
public class FarmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmServiceApplication.class, args);
    }

}
