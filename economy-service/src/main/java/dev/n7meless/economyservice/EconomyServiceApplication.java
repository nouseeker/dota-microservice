package dev.n7meless.economyservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Economy API",
        version = "1.0",
        description = "Documentation Economy-Service v1.0"),
        servers = @Server(url = "/api/economy", description = "Default Server Url"))
public class EconomyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EconomyServiceApplication.class, args);
    }

}
