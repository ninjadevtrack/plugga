package com.plugga.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @OneToMany(mappedBy = "deck",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<DeckCard> cards;

    @OneToMany(mappedBy = "deck")
    private List<UserDeck> users;

    public Deck() {
    }

    public Deck(final int id) {
        this.id = id;
        this.name = "";
        this.imageUrl = "";
    }

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

    @JsonIgnore
    public List<DeckCard> getCards() {
        return cards;
    }

    public void setCards(final List<DeckCard> cards) {
        this.cards = cards;
    }

    @JsonIgnore
    public List<UserDeck> getUsers() {
        return users;
    }

    public void setUsers(final List<UserDeck> users) {
        this.users = users;
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

    public void addCard(DeckCard card) {
        if (cards == null) {
            cards = new ArrayList<>();
        }
        cards.add(card);
    }
}
