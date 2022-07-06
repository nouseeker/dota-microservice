package com.example.dota.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "h1_id")
    private String h1_id;

    @Column(name = "h2_id")
    private String h2_id;

    @Column(name = "h3_id")
    private String h3_id;

    @Column(name = "h4_id")
    private String h4_id;

    @Column(name = "h5_id")
    private String h5_id;

    @Column(name = "h6_id")
    private String h6_id;

    @Column(name = "h7_id")
    private String h7_id;

    @Column(name = "h8_id")
    private String h8_id;

    @Column(name = "h9_id")
    private String h9_id;

    @Column(name = "h10_id")
    private String h10_id;

    @Column(name = "chance")
    private float chance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    public History(User user,
                   String h1_id,
                   String h2_id,
                   String h3_id,
                   String h4_id,
                   String h5_id,
                   String h6_id,
                   String h7_id,
                   String h8_id,
                   String h9_id,
                   String h10_id, float chance) {
        this.owner = user;
        this.h1_id = h1_id;
        this.h2_id = h2_id;
        this.h3_id = h3_id;
        this.h4_id = h4_id;
        this.h5_id = h5_id;
        this.h6_id = h6_id;
        this.h7_id = h7_id;
        this.h8_id = h8_id;
        this.h9_id = h9_id;
        this.h10_id = h10_id;
        this.chance = chance;
    }

    public History() {

    }
}
