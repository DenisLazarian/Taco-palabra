package com.udlproject.taco_palabra.persistence;


import com.udlproject.taco_palabra.domains.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    void save(Person person);

    void deleteById(Long id);
}
