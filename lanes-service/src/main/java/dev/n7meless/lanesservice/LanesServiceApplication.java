package dev.n7meless.lanesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LanesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanesServiceApplication.class, args);
    }
}
