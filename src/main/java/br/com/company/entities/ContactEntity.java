package br.com.company.entities;

import br.com.company.enumerations.TypePhone;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Data
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private TypePhone type;
    private String phone;

    public ContactEntity(Integer id, ClientEntity client, UserEntity user, TypePhone type, String phone) {
        this.id = id;
        this.client = client;
        this.user = user;
        this.type = type;
        this.phone = phone;
    }

    public ContactEntity(){

    }
}
