package br.com.company.controllers;

import br.com.company.controllers.exceptions.ContactNotFoundException;
import br.com.company.entities.ContactEntity;
import br.com.company.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping
    ResponseEntity<List<ContactEntity>> findAll(){
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ContactEntity> findById(@PathVariable Integer id){
        Optional<ContactEntity> contact = contactService.findById(id);
        if(contact.isPresent()){
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @GetMapping("/client/{id}")
    ResponseEntity<List<ContactEntity>> findAllByClientId(@PathVariable Integer id){
        List<ContactEntity> contacts = contactService.findAllByClientId(id);
        if(!contacts.isEmpty()){
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @PostMapping
    ResponseEntity<Boolean> save(@RequestBody ContactEntity contactEntity){
        contactService.save(contactEntity);
        return new ResponseEntity<>(true,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<ContactEntity> update(@RequestBody ContactEntity newContact, @PathVariable Integer id){
        Optional<ContactEntity> contactEntity = contactService.findById(id);
        if(contactEntity.isPresent()){
            return new ResponseEntity<>(contactService.save(contactService.checkNullFields(contactEntity.get(), newContact)),HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        if(contactService.existsById(id)){
            contactService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ContactNotFoundException(id);
    }

}
