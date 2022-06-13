package com.example.dota.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "heroes")
public class ero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "verylow")
    private String verylow;

    @Column(name = "low")
    private String low;

    @Column(name = "medium")
    private String medium;

    @Column(name = "high")
    private String high;

    @Column(name = "veryhigh")
    private String veryhigh;

    public Hero updateHero(String name, String verylow, String low, String medium, String high, String veryhigh){
        this.name = name;
        this.verylow = verylow;
        this.low = low;
        this.medium = medium;
        this.high = high;
        this.veryhigh = veryhigh;
        return this;
    }
}
