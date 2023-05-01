package dev.n7meless.counterservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Counter {
    @JsonProperty("localized_name")
    String localizedName;
    String date;
    @JsonProperty("updated_at")
    LocalDate updatedAt;
    List<Matchup> matchups;

}
