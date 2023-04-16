package dev.n7meless.heroservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Benchmark {
    @JsonSetter("gold_per_min")
    List<Percentile> goldPerMin;
    @JsonProperty("xp_per_min")
    List<Percentile> xpPerMin;
    @JsonProperty("last_hits_per_min")
    List<Percentile> lastHitsPerMin;
    @JsonProperty("hero_damage_per_min")
    List<Percentile> heroDamagePerMin;
    @JsonProperty("hero_healing_per_min")
    List<Percentile> heroHealingPerMin;
    @JsonProperty("tower_damage")
    List<Percentile> towerDamage;
    @JsonProperty("stuns_per_min")
    List<Percentile> stunsPerMin;
}