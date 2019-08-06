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

    public Side() {
    }

    public Side(final String imageUrl, final String text) {
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getCard() {
        return card;
    }

    public void setCard(final int card) {
        this.card = card;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Side{" +
                "id=" + id +
                ", card=" + card +
                ", imageUrl='" + imageUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
