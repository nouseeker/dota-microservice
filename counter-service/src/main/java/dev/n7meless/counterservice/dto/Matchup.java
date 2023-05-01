package dev.n7meless.counterservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matchup {
    String name;
    @JsonProperty("localized_name")
    String localizedName;
    Float disadvantage;
    @JsonProperty("win_rate")
    Float winRate;
    Long matches;

    public Matchup(String name, String localizedName, Float disadvantage, Float winRate, Long matches) {
        this.name = name;
        this.localizedName = localizedName.substring(8);
        this.disadvantage = disadvantage;
        this.winRate = winRate;
        this.matches = matches;
    }
}
