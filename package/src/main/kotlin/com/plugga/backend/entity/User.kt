package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import java.sql.Timestamp
import java.util.ArrayList

import javax.persistence.*

@Entity
@Table(name = "user")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Int = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "password")
    @get:JsonIgnore
    var password: String? = null

    @Column(name = "date_created")
    var dateCreated: Timestamp? = null

    @Column(name = "last_login")
    var lastLogin: Timestamp? = null

    @OneToMany(mappedBy = "user")
    private var decks: MutableList<UserDeck>? = null

    constructor() {}

    constructor(id: Int) {
        this.id = id
    }

    constructor(name: String, email: String, password: String) {
        this.name = name
        this.email = email
        this.password = password
        this.dateCreated = null
        this.lastLogin = null
    }

    @JsonIgnore
    fun getDecks(): MutableList<UserDeck>? {
        return decks
    }

    fun setDecks(decks: MutableList<UserDeck>) {
        this.decks = decks
    }

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", email='" + email + '\''.toString() +
                ", password='" + password + '\''.toString() +
                ", dateCreated=" + dateCreated +
                ", lastLogin=" + lastLogin +
                '}'.toString()
    }

    fun addDeck(deck: UserDeck) {
        if (decks == null) {
            decks = mutableListOf()
        }
        decks!!.add(deck)
    }
}
