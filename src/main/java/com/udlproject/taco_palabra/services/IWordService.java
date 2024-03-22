package com.udlproject.taco_palabra.services;

import com.udlproject.taco_palabra.domains.Word;

import java.util.List;
import java.util.Optional;

public interface IWordService {

    List<Word> findAll();

    Optional<Word> findById(Long id);

    void save(Word word);

    void deleteById(Long id);
}
