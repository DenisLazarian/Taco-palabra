package com.udlproject.taco_palabra.services.impl;

import com.udlproject.taco_palabra.domains.Person;
import com.udlproject.taco_palabra.persistence.IPersonDAO;
import com.udlproject.taco_palabra.services.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    private final IPersonDAO personDAO;

    public PersonServiceImpl(IPersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> findAll() {
        return this.personDAO.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return this.personDAO.findById(id);
    }

    @Override
    public void save(Person person) {
        this.personDAO.save(person);
    }

    @Override
    public void deleteById(Long id) {
        this.personDAO.deleteById(id);
    }
}
