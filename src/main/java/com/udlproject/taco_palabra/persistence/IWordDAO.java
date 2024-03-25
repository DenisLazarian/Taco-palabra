package com.udlproject.taco_palabra.persistence;

import com.udlproject.taco_palabra.domains.Word;

import java.util.List;
import java.util.Optional;


public interface IWordDAO {

    List<Word> findAll();

   Optional<Word> findById(Long id);

    void save(Word word);

    void deleteById(Long id);

    int addWordCounterByPerson(Long personId, Long wordId);
}
