package com.plugga.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="deck")
public class Deck {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="deck_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="date_created")
    private Timestamp dateCreated;

    public Deck() {}

    public Deck(String name, String imageUrl, Timestamp dateCreated) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
