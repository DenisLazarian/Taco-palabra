package com.udlproject.taco_palabra.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udlproject.taco_palabra.domains.PersonWordEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class WordDTO {

    private Long id;

    private String value;

    private List<PersonWordEntity> personWord = new ArrayList<>();


    public WordDTO(Long id, String value, List<PersonWordEntity> personWord) {
        this.id = id;
        this.value = value;
        this.personWord = personWord;
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
