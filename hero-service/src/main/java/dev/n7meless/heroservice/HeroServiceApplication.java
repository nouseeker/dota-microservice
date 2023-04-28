package dev.n7meless.heroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Hero API",
        version = "1.0",
        description = "Documentation Hero-Service v1.0"),
        servers = @Server(url = "/api/hero", description = "Default Server Url"))
public class HeroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroServiceApplication.class, args);
    }

}
