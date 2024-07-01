package com.TP_SpringBoot.TP_SpringBoot.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;



@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 25)
    private Long Id;

    private String Reponse;
    private Date ReponseDate;


    public Reponse(Long id, String reponse, Date reponseDate) {
       this.Id = id;
       this.Reponse = reponse;
       this.ReponseDate = reponseDate;
    }
    @ManyToOne
    private Formateur formateur;

    //Lien entre Reponse et ticket
    @OneToOne
    private Ticket ticket;

}
