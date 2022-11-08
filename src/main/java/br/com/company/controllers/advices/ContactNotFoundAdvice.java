package br.com.company.controllers.advices;

import br.com.company.controllers.exceptions.ContactNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ContactNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String contactNotFoundHandler(ContactNotFoundException e){
        return e.getMessage();
    }

}
