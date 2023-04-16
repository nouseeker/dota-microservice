package dev.n7meless.heroservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonAlias({"localized_name", "name"})
    private String name;
    @JsonProperty("attack_type")
    private String attackType;
    private List<String> roles;
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
}
