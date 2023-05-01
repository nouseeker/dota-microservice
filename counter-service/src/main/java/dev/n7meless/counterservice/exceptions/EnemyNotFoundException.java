package dev.n7meless.counterservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EnemyNotFoundException extends ResponseStatusException {
    public EnemyNotFoundException(String enemy) {
        super(HttpStatus.BAD_REQUEST, "Enemy with name " + enemy + " does not exists");
    }
}
