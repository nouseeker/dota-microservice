package dev.n7meless.heroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Percentile {
    @JsonProperty("percentile")
    private Float percentile;
    @JsonProperty("value")
    private Float value;

}
