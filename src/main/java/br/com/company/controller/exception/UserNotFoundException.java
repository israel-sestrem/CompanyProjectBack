package br.com.company.controller.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id){
        super("Could not find user " + id);
    }

}
