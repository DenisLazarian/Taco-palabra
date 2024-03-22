package com.udlproject.taco_palabra.persistence.dao;

import com.udlproject.taco_palabra.Repositories.PersonRepository;
import com.udlproject.taco_palabra.domains.Person;
import com.udlproject.taco_palabra.persistence.IPersonDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAOImpl implements IPersonDAO {

    private final PersonRepository personRepository;

    public PersonDAOImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
