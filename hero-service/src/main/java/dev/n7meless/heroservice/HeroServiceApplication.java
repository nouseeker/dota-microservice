package dev.n7meless.heroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HeroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroServiceApplication.class, args);
    }

}
