package com.udlproject.taco_palabra.Repositories;

import com.udlproject.taco_palabra.domains.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
