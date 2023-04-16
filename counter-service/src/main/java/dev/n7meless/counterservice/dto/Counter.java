package dev.n7meless.counterservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Counter {
    String localizedName;
    String date;
    LocalDate updatedAt;
    List<Matchup> matchups;
}
