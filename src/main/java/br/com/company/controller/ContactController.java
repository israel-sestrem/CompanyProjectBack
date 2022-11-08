package br.com.company.controller;

import br.com.company.controller.exception.ContactNotFoundException;
import br.com.company.entity.ContactEntity;
import br.com.company.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/contacts")
    ResponseEntity<List<ContactEntity>> findAll(){
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/contacts/{id}")
    ResponseEntity<ContactEntity> findById(@PathVariable Integer id){
        Optional<ContactEntity> contact = contactService.findById(id);
        if(contact.isPresent()){
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @GetMapping("/contacts/client/{id}")
    ResponseEntity<List<ContactEntity>> findAllByClientId(@PathVariable Integer id){
        List<ContactEntity> contacts = contactService.findAllByClientId(id);
        if(!contacts.isEmpty()){
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @PostMapping("/contacts")
    ResponseEntity<ContactEntity> save(@RequestBody ContactEntity contactEntity){
        return new ResponseEntity<>(contactService.save(contactEntity),HttpStatus.CREATED);
    }

    @PutMapping("/contacts/{id}")
    ResponseEntity<ContactEntity> update(@RequestBody ContactEntity newContact, @PathVariable Integer id){
        Optional<ContactEntity> contactEntity = contactService.findById(id);
        if(contactEntity.isPresent()){
            return new ResponseEntity<>(contactService.save(contactService.checkNullFields(contactEntity.get(), newContact)),HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @DeleteMapping("/contacts/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        if(contactService.existsById(id)){
            contactService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

}
