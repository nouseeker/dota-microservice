package dev.n7meless.dota.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
    private Long id;
    private String firstname;
    private String lastname;
}
