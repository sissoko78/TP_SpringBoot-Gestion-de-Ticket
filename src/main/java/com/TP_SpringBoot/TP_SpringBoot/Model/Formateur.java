package com.TP_SpringBoot.TP_SpringBoot.Model;


import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Formateur")
@NoArgsConstructor
@Entity
@Data

public class Formateur extends User{


    public Formateur(Long Id,String Username, String Nom, String Prenom, String Email, String Password, Role role) {
        super(Id, Username, Nom, Prenom, Email, Password, role=Role.Formateur);

    }



    //Lien entre Formateur et Reponse
    @OneToMany(mappedBy = "formateur",fetch = FetchType.LAZY)
    private List<Reponse> reponse;
}
