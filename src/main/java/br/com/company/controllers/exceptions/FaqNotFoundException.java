package br.com.company.controllers.exceptions;

public class FaqNotFoundException extends RuntimeException {

    public FaqNotFoundException(Integer id){
        super("Could not find faq " + id);
    }

}
