package dev.n7meless.economyservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class HeroNotFoundException extends ResponseStatusException {
    public HeroNotFoundException(String name) {
        super(HttpStatus.BAD_REQUEST, "Hero with " + name + "does not exists");
    }
}
