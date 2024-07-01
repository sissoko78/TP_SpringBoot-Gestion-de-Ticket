package com.TP_SpringBoot.TP_SpringBoot.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Base_Connaissance {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 25)
    private Long Id;
    private String Question;
    private String Reponse;

    public Base_Connaissance(Long id, String question, String reponse) {
        this.Id = id;
        this.Question = question;
        this.Reponse = reponse;
    }
    //Lien entre Admin et base de connaissance
    @ManyToOne
    private Admin admin;
}
