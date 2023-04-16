package dev.n7meless.heroservice.dto;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    @JsonSetter("localized_name")
    private String name;
    @JsonIgnore
    private String localizedName;
    private String img;
    private String icon;
    private List<String> roles;
    @JsonProperty("attack_type")
    private String attackType;
    @JsonProperty("base_health")
    private Integer health;
    @JsonProperty("base_health_regen")
    private Float healthRegen;
    @JsonProperty("base_mana")
    private Integer mana;
    @JsonProperty("base_mana_regen")
    private Float manaRegen;
    @JsonProperty("base_armor")
    private Integer armor;
    @JsonProperty("base_str")
    private Integer strength;
    @JsonProperty("str_gain")
    private Float strengthGain;
    @JsonProperty("base_agi")
    private Integer agility;
    @JsonProperty("agi_gain")
    private Float agilityGain;
    @JsonProperty("base_int")
    private Integer intellect;
    @JsonProperty("int_gain")
    private Float intellectGain;
    @JsonProperty("attack_range")
    private Integer attackRange;
    @JsonProperty("base_attack_time")
    private Integer attackTime;
    @JsonProperty("move_speed")
    private Integer moveSpeed;

    public void setImg(String img) {
        this.img = "https://api.opendota.com" + img;
    }

    public void setIcon(String icon) {
        this.icon = "https://api.opendota.com" + icon;
    }

    public void setName(String name) {
        this.name = name;
        this.localizedName = name.replaceAll(" ", "-").toLowerCase();
    }

    @JsonGetter("localized_name")
    public String getLocalizedName() {
        return localizedName;
    }
}
