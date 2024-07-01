package com.TP_SpringBoot.TP_SpringBoot.Model;


import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String Nom;
    @Column(length = 50)
    private String Prenom;
    @Column(length = 50)
    private String Email;
    @Column(length = 250)
    private String Password;
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Role role;

}
