package br.com.company.controllers.advices;

import br.com.company.controllers.exceptions.AddressNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddressNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String addressNotFoundHandler(AddressNotFoundException e){
        return e.getMessage();
    }

}
