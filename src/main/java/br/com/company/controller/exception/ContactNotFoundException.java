package br.com.company.controller.exception;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(Integer id){
        super("Could not find contact " + id);
    }

}
