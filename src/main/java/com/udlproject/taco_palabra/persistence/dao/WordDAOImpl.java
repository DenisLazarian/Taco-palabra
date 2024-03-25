package com.udlproject.taco_palabra.persistence.dao;

import com.udlproject.taco_palabra.Repositories.PersonRepository;
import com.udlproject.taco_palabra.Repositories.WordPersonRepository;
import com.udlproject.taco_palabra.Repositories.WordRepository;
import com.udlproject.taco_palabra.domains.Person;
import com.udlproject.taco_palabra.domains.PersonWordEntity;
import com.udlproject.taco_palabra.domains.Word;
import com.udlproject.taco_palabra.persistence.IWordDAO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class WordDAOImpl implements IWordDAO {

    WordRepository wordRepository;
    WordPersonRepository wordPersonRepository;

    PersonRepository personRepository;

    public WordDAOImpl(
            WordRepository wordRepository,
            WordPersonRepository wordPersonRepository,
            PersonRepository personRepository
    ){
        this.wordRepository = wordRepository;
        this.wordPersonRepository = wordPersonRepository;
        this.personRepository = personRepository;
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

    @Override
    public int addWordCounterByPerson(Long personId, Long wordId) {
        Optional<Word> wordOptional = findById(wordId);
        Optional<Person> personOptional = this.personRepository.findById(personId);

        if(wordOptional.isPresent() && personOptional.isPresent()){
            PersonWordEntity personWord = new PersonWordEntity(
                    personOptional.get(),
                    wordOptional.get(),
                    new Date()
            );
            wordPersonRepository.save(personWord);
            return 0;
        }
        System.out.println("Something went wrong!!");
        return -1;
    }
}
