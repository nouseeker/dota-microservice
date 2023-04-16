package dev.n7meless.heroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonRootName("gold_per_min")
public class Percentile {
    @JsonProperty("percentile")
    public Float percentile;
    @JsonProperty("value")
    public Float value;

}
