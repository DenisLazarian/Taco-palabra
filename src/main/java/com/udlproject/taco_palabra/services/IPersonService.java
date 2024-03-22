package com.udlproject.taco_palabra.services;

import com.udlproject.taco_palabra.domains.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    void save(Person person);

    void deleteById(Long id);
}
