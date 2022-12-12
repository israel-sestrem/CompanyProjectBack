package br.com.company.controllers;

import br.com.company.controllers.exceptions.FaqNotFoundException;
import br.com.company.entities.FaqEntity;
import br.com.company.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/faq")
public class FaqController {

    @Autowired
    FaqService faqService;

    @GetMapping
    ResponseEntity<List<FaqEntity>> findAll(){
        return new ResponseEntity<>(faqService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<FaqEntity> findById(@PathVariable Integer id){
        Optional<FaqEntity> faq = faqService.findById(id);
        if(faq.isPresent())
            return new ResponseEntity<>(faq.get(), HttpStatus.OK);
        throw new FaqNotFoundException(id);
    }

    @GetMapping("/exists/{id}")
    ResponseEntity<Boolean> existsById(@PathVariable Integer id){
        return new ResponseEntity<>(faqService.existsById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<String> save(@RequestBody FaqEntity faq){
        return new ResponseEntity<>(faqService.save(faq).getId().toString(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Boolean> update(@RequestBody FaqEntity newFaq, @PathVariable Integer id){
        Optional<FaqEntity> faqEntity = faqService.findById(id);
        if(faqEntity.isPresent()){
            faqService.save(faqService.checkNullFields(faqEntity.get(), newFaq));
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        throw new FaqNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Integer id){
        if(faqService.existsById(id)){
            faqService.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        throw new FaqNotFoundException(id);
    }

}
