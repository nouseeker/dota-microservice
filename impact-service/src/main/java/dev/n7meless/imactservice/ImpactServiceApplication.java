package dev.n7meless.imactservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Demo",
        version = "2.0",
        description = "Documentation APIs v1.0"),
        servers = @Server(url = "/api/impact", description = "Default Server Url"))
public class ImpactServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpactServiceApplication.class, args);
    }

}
