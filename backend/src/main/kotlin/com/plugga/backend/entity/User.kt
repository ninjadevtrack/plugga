package com.plugga.backend.entity

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.plugga.backend.jackson.EntityIdResolver
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "user")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator::class,
    property = "id",
    resolver = EntityIdResolver::class,
    scope = User::class
)
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Int = 0

    @Column(name = "name")
    var name: String? = null

    @Column(name = "email", unique = true)
    var email: String? = null

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null

    @Column(name = "date_created", updatable = false)
    var dateCreated: Timestamp? = null

    @Column(name = "last_login")
    var lastLogin: Timestamp? = null

    @OneToMany(mappedBy = "user")
    @get:JsonIgnore
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
