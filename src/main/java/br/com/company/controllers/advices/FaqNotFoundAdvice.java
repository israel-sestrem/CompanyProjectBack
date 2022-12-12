package br.com.company.controllers.advices;

import br.com.company.controllers.exceptions.FaqNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FaqNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FaqNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String faqNotFoundHandler(FaqNotFoundException e){
        return e.getMessage();
    }

}
