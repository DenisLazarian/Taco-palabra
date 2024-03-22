package com.udlproject.taco_palabra.controllers;


import com.udlproject.taco_palabra.controllers.dto.PersonDTO;
import com.udlproject.taco_palabra.domains.Person;
import com.udlproject.taco_palabra.services.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService){
        this.personService = personService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Person> pOpt = this.personService.findById(id);

        if(pOpt.isPresent()){
            Person person = pOpt.get();

            PersonDTO personDTO = new PersonDTO(
                    person.getId(),
                    person.getName(),
                    person.getDate_created(),
                    person.getPersonWord()
            );

            return ResponseEntity.ok(personDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
