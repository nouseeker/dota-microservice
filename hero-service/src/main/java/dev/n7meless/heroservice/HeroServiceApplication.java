package dev.n7meless.heroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info =
@Info(title = "Organization API", version = "3.0", description = "Documentation Organization API v2.0"))
public class HeroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroServiceApplication.class, args);
    }

}
