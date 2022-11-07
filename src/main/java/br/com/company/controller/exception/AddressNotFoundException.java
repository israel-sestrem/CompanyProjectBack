package br.com.company.controller.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(Integer id){
        super("Could not find address " + id);
    }

}
