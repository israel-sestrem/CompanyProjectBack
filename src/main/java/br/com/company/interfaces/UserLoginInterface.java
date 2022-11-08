package br.com.company.interfaces;

import lombok.Data;

@Data
public class UserLoginInterface {

    private String email;
    private String password;

    public UserLoginInterface(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
