package br.com.company.controllers;

import br.com.company.controllers.exceptions.UserNotFoundException;
import br.com.company.entities.UserEntity;
import br.com.company.interfaces.UserLoginInterface;
import br.com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<UserEntity>> findAll(){
        return new ResponseEntity<>(userService.decodeAll(userService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserEntity> findById(@PathVariable Integer id){
        Optional<UserEntity> user = userService.findById(id);
        if(user.isPresent()){
            user.get().setPassword(userService.decode(user.get().getPassword()));
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @GetMapping("/users/client/{id}")
    ResponseEntity<List<UserEntity>> findAllByClientId(@PathVariable Integer id){
        List<UserEntity> users = userService.decodeAll(userService.findAllByClientId(id));
        if(!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @PostMapping("/users")
    ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        user.setPassword(userService.encode(user.getPassword()));
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    ResponseEntity<Boolean> validateUser(@RequestBody UserLoginInterface request){
        return new ResponseEntity<>(userService.validateUser(request.getEmail(), request.getPassword()), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<UserEntity> update(@RequestBody UserEntity newUser, @PathVariable Integer id){
        Optional<UserEntity> userEntity = userService.findById(id);
        if(userEntity.isPresent()){
            return new ResponseEntity<>(userService.save(userService.checkNullFields(userEntity.get(), newUser)), HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        if(userService.existsById(id)){
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }
}