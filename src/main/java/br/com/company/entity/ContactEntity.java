package br.com.company.entity;

import br.com.company.enumeration.TypePhone;
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
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private ClientEntity client;
    @Enumerated(EnumType.STRING)
    private TypePhone type;
    private String phone;

    public ContactEntity(Integer id, ClientEntity client, TypePhone type, String phone) {
        this.id = id;
        this.client = client;
        this.type = type;
        this.phone = phone;
    }

    public ContactEntity(){

    }
}
