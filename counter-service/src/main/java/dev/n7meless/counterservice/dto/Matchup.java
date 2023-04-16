package dev.n7meless.counterservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Matchup {
    String name;
    String localizedName;
    Float disadvantage;
    Float winRate;
    Long matches;
}
