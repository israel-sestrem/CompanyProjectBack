package br.com.company.controller.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Integer id){
        super("Could not find client " + id);
    }

}
