package com.TP_SpringBoot.TP_SpringBoot.Model;



import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@DiscriminatorValue("Admin")

@NoArgsConstructor
@Entity
@Getter
@Setter

public class Admin extends User {


    public Admin(Long Id, String Username, String Nom, String Prenom, String Email, String Password, Role role) {
        super(Id, Username, Nom, Prenom, Email, Password, Role.Admin);
;
    }


    //Lien entre Admin et Base de Connaissance
    @OneToMany(mappedBy = "admin", fetch= FetchType.LAZY)
    private List<Base_Connaissance>baseConnaissances;

}
