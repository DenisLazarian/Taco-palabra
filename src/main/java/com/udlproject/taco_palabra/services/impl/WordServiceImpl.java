package com.udlproject.taco_palabra.services.impl;

import com.udlproject.taco_palabra.domains.Word;
import com.udlproject.taco_palabra.persistence.IWordDAO;
import com.udlproject.taco_palabra.services.IWordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements IWordService {

    private final IWordDAO wordDAO;

    public WordServiceImpl(IWordDAO wordDAO){
        this.wordDAO = wordDAO;
    }


    @Override
    public List<Word> findAll() {
        return this.wordDAO.findAll();
    }

    @Override
    public Optional<Word> findById(Long id) {
        return this.wordDAO.findById(id);
    }

    @Override
    public void save(Word word) {
        this.wordDAO.save(word);
    }

    @Override
    public void deleteById(Long id) {
        this.wordDAO.deleteById(id);
    }
}
