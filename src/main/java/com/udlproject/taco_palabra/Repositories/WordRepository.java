package com.udlproject.taco_palabra.Repositories;

import com.udlproject.taco_palabra.domains.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word,Long> {
}
