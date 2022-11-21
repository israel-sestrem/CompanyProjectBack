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

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    ResponseEntity<List<ClientEntity>> findAll(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ClientEntity> findById(@PathVariable Integer id){
        Optional<ClientEntity> client = clientService.findById(id);
        if(client.isPresent()){
            return new ResponseEntity<>(client.get(),HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

    @PostMapping
    ResponseEntity<Boolean> save(@RequestBody ClientEntity client){
        clientService.save(client);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Boolean> update(@RequestBody ClientEntity newClient, @PathVariable Integer id){
        Optional<ClientEntity> clientEntity = clientService.findById(id);
        if(clientEntity.isPresent()){
            clientService.save(clientService.checkNullFields(clientEntity.get(), newClient));
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Integer id){
        if(clientService.existsById(id)){
            clientService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        throw new ClientNotFoundException(id);
    }

}
