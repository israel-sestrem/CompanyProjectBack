package br.com.company.controllers;

import br.com.company.controllers.exceptions.UserNotFoundException;
import br.com.company.entities.UserEntity;
import br.com.company.interfaces.RecUserLoginInterface;
import br.com.company.interfaces.SignupInterface;
import br.com.company.interfaces.UserLoginInterface;
import br.com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<List<UserEntity>> findAll(){
        return new ResponseEntity<>(userService.decodeAll(userService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserEntity> findById(@PathVariable Integer id){
        Optional<UserEntity> user = userService.findById(id);
        if(user.isPresent()){
            user.get().setPassword(userService.decode(user.get().getPassword()));
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @GetMapping("/client/{id}")
    ResponseEntity<List<UserEntity>> findAllByClientId(@PathVariable Integer id){
        List<UserEntity> users = userService.decodeAll(userService.findAllByClientId(id));
        if(!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @PostMapping
    ResponseEntity<String> save(@RequestBody SignupInterface userClient){
        userClient.setPassword(userService.encode(userClient.getPassword()));
        return new ResponseEntity<>(userService.saveWithClient(userClient).getId().toString(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<RecUserLoginInterface> validateUser(@RequestBody UserLoginInterface request){
        RecUserLoginInterface userLogged = userService.validateUser(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(userLogged, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserEntity> update(@RequestBody UserEntity newUser, @PathVariable Integer id){
        Optional<UserEntity> userEntity = userService.findById(id);
        if(userEntity.isPresent()){
            return new ResponseEntity<>(userService.save(userService.checkNullFields(userEntity.get(), newUser)), HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        if(userService.existsById(id)){
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }
}
