package com.TP_SpringBoot.TP_SpringBoot.Model;




import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@DiscriminatorValue("Apprenant")
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Apprenant extends User{


    public Apprenant(Long Id, String Username, String Nom, String Prenom, String Email, String Password, Role role, Formateur formateur) {
        super(Id, Username, Nom, Prenom, Email, Password, Role.Apprenant);

    }


    //Lien apprenant et ticket
    @OneToMany(mappedBy = "apprenant", fetch= FetchType.LAZY)
    private List<Ticket>ticket;

}
