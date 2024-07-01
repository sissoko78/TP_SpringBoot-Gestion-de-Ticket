package com.TP_SpringBoot.TP_SpringBoot.Model;

import com.TP_SpringBoot.TP_SpringBoot.Enum.Categorie;
import com.TP_SpringBoot.TP_SpringBoot.Enum.Priorite;
import com.TP_SpringBoot.TP_SpringBoot.Enum.Statut;
import jakarta.persistence.*;

import lombok.*;

import java.util.Date;



@NoArgsConstructor
@Data
@Getter
@Setter
@Entity


public class Ticket {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 25)
    private String Description;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @Column(length = 25)
    @Enumerated(EnumType.STRING)
    private Priorite priorite;
    @Column(length = 25)
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @Column(length = 25)
    private Date date;

    public Ticket(Long id, String description, Categorie categorie, Priorite priorite, Statut statut, Date date) {
        this.Id = id;
        this.Description = description;
        this.categorie = categorie;
        this.priorite = priorite;
        this.statut = Statut.En_cours;
        this.date = date;
    }
    //Lien entre ticket et apprenant
    @ManyToOne
    private User apprenant;

    //Lien entre Ticket et Reponse
    @OneToOne (mappedBy = "ticket")
    private Reponse reponse;
}

