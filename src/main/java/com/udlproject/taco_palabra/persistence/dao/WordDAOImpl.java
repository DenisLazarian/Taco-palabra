package com.udlproject.taco_palabra.persistence.dao;

import com.udlproject.taco_palabra.Repositories.WordRepository;
import com.udlproject.taco_palabra.domains.Word;
import com.udlproject.taco_palabra.persistence.IWordDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WordDAOImpl implements IWordDAO {

    WordRepository wordRepository;

    public WordDAOImpl(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    @Override
    public List<Word> findAll() {
        return (List<Word>) wordRepository.findAll();
    }

    @Override
    public Optional<Word> findById(Long id) {
        return wordRepository.findById(id);
    }

    @Override
    public void save(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteById(Long id) {
        wordRepository.deleteById(id);
    }
}
