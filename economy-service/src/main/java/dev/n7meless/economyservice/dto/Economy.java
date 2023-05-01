package dev.n7meless.economyservice.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Economy {
    String hero;
    String localizedName;
    Float gold;
    Float experience;

    @JsonGetter("localized_name")
    public String getLocalizedName() {
        return localizedName.substring(8);
    }
}
