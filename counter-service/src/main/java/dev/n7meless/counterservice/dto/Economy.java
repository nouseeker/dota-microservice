package dev.n7meless.counterservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Economy {
    String name;
    @JsonProperty("image_name")
    String imageName;
    Float gold;
    Float experience;
}
