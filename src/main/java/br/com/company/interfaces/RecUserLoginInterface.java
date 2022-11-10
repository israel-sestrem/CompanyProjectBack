package br.com.company.interfaces;

import lombok.Data;

@Data
public class RecUserLoginInterface {

    private Boolean isValid;
    private String id;

    public RecUserLoginInterface(Boolean isValid, String id) {
        this.isValid = isValid;
        this.id = id;
    }

    public RecUserLoginInterface(){

    }
}
