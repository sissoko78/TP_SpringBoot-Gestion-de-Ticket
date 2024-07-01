package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Apprenant;
import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;

import java.util.List;

public interface ApprenantService {
    Apprenant CreerApprenant(Apprenant apprenant);

    List<Apprenant> lireApprenants();

    Apprenant modifyApprenant( Long Id ,Apprenant apprenant);

    String deleteApprenant(Long Id);
}
