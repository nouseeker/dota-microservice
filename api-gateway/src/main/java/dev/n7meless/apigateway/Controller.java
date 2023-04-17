package dev.n7meless.apigateway;

import jakarta.ws.rs.GET;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping
    public String getHello(){
        return "Hello";
    }
}
