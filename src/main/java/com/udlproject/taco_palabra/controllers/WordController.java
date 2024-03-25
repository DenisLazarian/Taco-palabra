package com.udlproject.taco_palabra.controllers;

import com.udlproject.taco_palabra.controllers.dto.WordDTO;
import com.udlproject.taco_palabra.domains.Word;
import com.udlproject.taco_palabra.services.IWordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/word")
public class WordController {

    IWordService wordService;

    public WordController(IWordService wordService){
        this.wordService = wordService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll(){
        List<WordDTO> wordList = wordService.findAll()
                .stream()
                .map(word -> new WordDTO(
                        word.getId(),
                        word.getValue(),
                        word.getPersonWord()
                )).toList();

        return ResponseEntity.ok(wordList);
    }

    /**
     * Los Post se usan para envio de formularios en la  funcionalidad de
     * guardar registro.
     *
     * Aquí guardamos el registro palabra, que queramos guardar.
     * */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam String value) throws URISyntaxException {
        if(value.isBlank()) return ResponseEntity.badRequest().build();

        wordService.save(new Word(value));
        return ResponseEntity.created(new URI("/api/word/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWord(@PathVariable Long id, @RequestParam String value){
        Optional<Word> wordOptional = wordService.findById(id);

        if(wordOptional.isPresent()){
            Word word = wordOptional.get();
            word.setValue(value);
            wordService.save(word);
            return ResponseEntity.ok("Word updated with exit.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWord(@PathVariable Long id){
        if(id != null){
            wordService.deleteById(id);
            return ResponseEntity.ok("Word deleted with exit.");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getWordById(@PathVariable Long id){
       Optional<Word> wordOptional = wordService.findById(id);

       if(wordOptional.isPresent()){
           Word word = wordOptional.get();
           WordDTO wordDTO = new WordDTO(
                   word.getId(),
                   word.getValue(),
                   word.getPersonWord()
           );
           return ResponseEntity.ok(wordDTO);
       }

       return ResponseEntity.notFound().build();
    }

    @PostMapping("/add/{person_id}/{word_id}")
    public ResponseEntity<?> addWordCounterByPerson(@PathVariable Long person_id, @PathVariable Long word_id){
        int result = wordService.addWordCounterByPerson(person_id, word_id);

        if(result < 0) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok("Word counted with exit.");
    }


}
