package dev.n7meless.counterservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Matchup {
    String name;
    @JsonProperty("localized_name")
    String localizedName;
    Float disadvantage;
    @JsonProperty("win_rate")
    Float winRate;
    Long matches;
}
