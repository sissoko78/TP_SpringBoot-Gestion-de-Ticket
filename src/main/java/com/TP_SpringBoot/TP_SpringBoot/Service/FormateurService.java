package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur CreerFormateur(Formateur formateur);

    List<Formateur> lireFormateurs();

    Formateur modifyFormateur( Long Id ,Formateur formateur);

    String deleteFormateur(Long Id);

}
