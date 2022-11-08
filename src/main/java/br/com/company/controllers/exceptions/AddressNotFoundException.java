package br.com.company.controllers.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(Integer id){
        super("Could not find address " + id);
    }

}
