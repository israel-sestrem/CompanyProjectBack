package br.com.company.controllers;

import br.com.company.controllers.exceptions.ClientNotFoundException;
import br.com.company.entities.ClientEntity;
import br.com.company.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    ResponseEntity<List<ClientEntity>> findAll(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    ResponseEntity<ClientEntity> findById(@PathVariable Integer id){
        Optional<ClientEntity> client = clientService.findById(id);
        if(client.isPresent()){
            return new ResponseEntity<>(client.get(),HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

    @PostMapping(value = "/clients")
    ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping("/clients/{id}")
    ResponseEntity<ClientEntity> update(@RequestBody ClientEntity newClient, @PathVariable Integer id){
        Optional<ClientEntity> clientEntity = clientService.findById(id);
        if(clientEntity.isPresent()){
            return new ResponseEntity<>(clientService.save(clientService.checkNullFields(clientEntity.get(), newClient)),HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

    @DeleteMapping("/clients/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        if(clientService.existsById(id)){
            clientService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

}
