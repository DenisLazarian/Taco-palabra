package com.udlproject.taco_palabra.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity (name = "word")
public class Word {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String value;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<PersonWordEntity> personWord = new ArrayList<>();

    public Word(){}

    public Word(Long id, String value, List<PersonWordEntity> personWord) {
        this.id = id;
        this.value = value;
        this.personWord = personWord;
    }
    public Word(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<PersonWordEntity> getPersonWord() {
        return personWord;
    }

    public void setPersonWord(List<PersonWordEntity> personWord) {
        this.personWord = personWord;
    }
}
