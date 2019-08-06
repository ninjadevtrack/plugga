package com.plugga.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="side")
public class Side {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="side_id")
    private int id;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="card_id")
    private int card;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="text")
    private String text;
}
