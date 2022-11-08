package br.com.company.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private ClientEntity client;
    private String cnpj;
    private String address;
    private Integer number;
    private String complement;
    private String neighborhood;
    @Column(name = "zip_code")
    private String zipCode;
    private String state;
    private String city;

    public AddressEntity(Integer id, ClientEntity client, String cnpj, String address, Integer number, String complement, String neighborhood, String zipCode, String state, String city) {
        this.id = id;
        this.client = client;
        this.cnpj = cnpj;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
    }

    public AddressEntity(){

    }
}
