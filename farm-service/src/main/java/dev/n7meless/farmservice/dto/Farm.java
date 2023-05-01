package dev.n7meless.farmservice.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    String name;
    String localizedName;
    Float lastHits;
    Float denies;

    @JsonGetter("localized_name")
    public String getLocalizedName() {
        return localizedName.substring(8);
    }
}
