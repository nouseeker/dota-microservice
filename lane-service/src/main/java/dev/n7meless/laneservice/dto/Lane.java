package dev.n7meless.laneservice.dto;

import dev.n7meless.laneservice.dto.enums.LaneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Lane {
    String imageName;
    String name;
    Float presence;
    Float winRate;
    Float kda;
    Integer gpm;
    Integer xpm;
    LaneEnum lane;
}