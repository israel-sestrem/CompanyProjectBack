package br.com.company.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "current_client_id")
    private Integer clientId;
    private String name;
    private String password;
    private String email;

    public UserEntity(Integer id, Integer clientId, String name, String password, String email) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserEntity(){

    }
}
