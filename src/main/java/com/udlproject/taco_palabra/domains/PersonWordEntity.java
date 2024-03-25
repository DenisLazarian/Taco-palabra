package com.udlproject.taco_palabra.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity (name = "person_word")
public class PersonWordEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "word_id")
    @JsonIgnore
    private Word word;

    @Column(name = "date_spoken", nullable = false)
    private Date dateSpoken;


    public PersonWordEntity(Person person, Word word, Date dateSpoken) {
        this.person = person;
        this.word = word;
        this.dateSpoken = dateSpoken;
    }
}
