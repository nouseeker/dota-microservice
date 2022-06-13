package com.example.dota.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "h1")
    private int h1;
    @Column(name = "h2")
    private int h2;
    @Column(name = "h3")
    private int h3;
    @Column(name = "h4")
    private int h4;
    @Column(name = "h5")
    private int h5;
    @Column(name = "h6")
    private int h6;
    @Column(name = "h7")
    private int h7;
    @Column(name = "h8")
    private int h8;
    @Column(name = "h9")
    private int h9;
    @Column(name = "h10")
    private int h10;

    public History(int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, int h10) {
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.h4 = h4;
        this.h5 = h5;
        this.h6 = h6;
        this.h7 = h7;
        this.h8 = h8;
        this.h9 = h9;
        this.h10 = h10;
    }

    public History() {

    }
}