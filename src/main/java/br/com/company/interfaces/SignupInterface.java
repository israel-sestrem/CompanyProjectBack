package br.com.company.interfaces;

import lombok.Data;

@Data
public class SignupInterface {

    private String name;
    private String email;
    private String password;
    private String clientName;
    private String clientEmail;

    public SignupInterface(String name, String email, String password, String clientName, String clientEmail) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }
}
