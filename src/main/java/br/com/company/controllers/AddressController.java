package br.com.company.controllers;

import br.com.company.controllers.exceptions.AddressNotFoundException;
import br.com.company.entities.AddressEntity;
import br.com.company.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    ResponseEntity<List<AddressEntity>> findAll(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<AddressEntity> findById(@PathVariable Integer id){
        Optional<AddressEntity> address = addressService.findById(id);
        if(address.isPresent()){
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        }
        throw new AddressNotFoundException(id);
    }

    @GetMapping("/client/{id}")
    ResponseEntity<List<AddressEntity>> findAllByClientId(@PathVariable Integer id){
        List<AddressEntity> addresses = addressService.findAllByClientId(id);
        if(!addresses.isEmpty()){
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }
        throw new AddressNotFoundException(id);
    }

    @PostMapping
    ResponseEntity<Boolean> save(@RequestBody AddressEntity address){
        addressService.save(address);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Boolean> update(@RequestBody AddressEntity newAddress, @PathVariable Integer id){
        Optional<AddressEntity> addressEntity = addressService.findById(id);
        if(addressEntity.isPresent()){
            addressService.save(addressService.checkNullFields(addressEntity.get(), newAddress));
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        throw new AddressNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Integer id){
        if(addressService.existsById(id)){
            addressService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        throw new AddressNotFoundException(id);
    }

}
