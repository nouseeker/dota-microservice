package dev.n7meless.farmservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Farm {
    String name;
    String imageName;
    Float lastHits;
    Float denies;
}
