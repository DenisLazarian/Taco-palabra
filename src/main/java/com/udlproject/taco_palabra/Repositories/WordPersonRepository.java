package com.udlproject.taco_palabra.Repositories;

import com.udlproject.taco_palabra.domains.PersonWordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordPersonRepository extends CrudRepository<PersonWordEntity, Long> {

}
