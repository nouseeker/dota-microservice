package dev.n7meless.laneservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Lane {
    String localizedName;
    String name;
    Float presence;
    Float winRate;
    Float kda;
    Integer gpm;
    Integer xpm;
    String position;
}
