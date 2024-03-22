package com.udlproject.taco_palabra.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity (name = "person")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Date date_created;

    @Column(name = "word_id")
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<PersonWordEntity> personWord = new ArrayList<>();

    public Person(){}

    public Person(Long id, String name, List<PersonWordEntity> personWord) {
        this.id = id;
        this.name = name;
        this.date_created = new Date();
        this.personWord = personWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public List<PersonWordEntity> getPersonWord() {
        return personWord;
    }

    public void setPersonWord(List<PersonWordEntity> personWord) {
        this.personWord = personWord;
    }
}
