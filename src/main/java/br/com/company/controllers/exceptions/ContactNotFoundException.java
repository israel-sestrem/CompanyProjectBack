package br.com.company.controllers.exceptions;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(Integer id){
        super("Could not find contact " + id);
    }

}
