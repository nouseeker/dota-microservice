package dev.n7meless.heroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class HeroNotFoundException extends ResponseStatusException {
    public HeroNotFoundException(HttpStatusCode status, String name) {
        super(HttpStatus.BAD_REQUEST, "Hero with " + name + "does not exists");
    }
}
