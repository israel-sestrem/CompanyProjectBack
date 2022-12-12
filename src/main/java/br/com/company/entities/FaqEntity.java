package br.com.company.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "faq")
@Data
public class FaqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private String answer;

    public FaqEntity(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public FaqEntity(){

    }
}
