package com.udlproject.taco_palabra.controllers.dto;

import com.udlproject.taco_palabra.domains.PersonWordEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonDTO {

    private Long id;
    private String name;
    private Date date_created;

    private List<PersonWordEntity> personWord = new ArrayList<>();

    public PersonDTO(Long id, String name, Date date_created, List<PersonWordEntity> personWord) {
        this.id = id;
        this.name = name;
        this.date_created = date_created;
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
