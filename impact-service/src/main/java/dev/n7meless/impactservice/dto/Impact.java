package dev.n7meless.impactservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Impact {
    String name;
    String localizedName;
    Float kda;
    Float kills;
    Float deaths;
    Float assists;
    String matchDuration;
}
