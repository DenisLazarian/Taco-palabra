package com.udlproject.taco_palabra.controllers;


import com.udlproject.taco_palabra.controllers.dto.PersonDTO;
import com.udlproject.taco_palabra.controllers.dto.WordDTO;
import com.udlproject.taco_palabra.domains.Person;
import com.udlproject.taco_palabra.domains.Word;
import com.udlproject.taco_palabra.services.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService){
        this.personService = personService;
    }


    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        List<WordDTO> personList = personService.findAll()
                .stream()
                .map(person -> new WordDTO(
                        person.getId(),
                        person.getName(),
                        person.getPersonWord()
                )).toList();

        return ResponseEntity.ok(personList);
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

    @PutMapping("/save")
    public ResponseEntity<?> save(@RequestParam String name) throws URISyntaxException {
        if(name.isBlank()) return ResponseEntity.badRequest().build();

        personService.save(new Person(name));
        return ResponseEntity.created(new URI("/api/person/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWord(@PathVariable Long id, @RequestParam String name){
        Optional<Person> personOptional = personService.findById(id);

        if(personOptional.isPresent()){
            Person person = personOptional.get();
            person.setName(name);
            personService.save(person);
            return ResponseEntity.ok("Word updated with exit.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWord(@PathVariable Long id){
        if(id != null){
            personService.deleteById(id);
            return ResponseEntity.ok("Word deleted with exit.");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getWordById(@PathVariable Long id){
        Optional<Person> personOptional = personService.findById(id);

        if(personOptional.isPresent()){
            Person person = personOptional.get();
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
