package dev.n7meless.laneservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Lane API",
        version = "1.0",
        description = "Documentation Lane-Service v1.0"),
        servers = @Server(url = "/api/lane", description = "Default Server Url"))
public class LaneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaneServiceApplication.class, args);
    }
}
