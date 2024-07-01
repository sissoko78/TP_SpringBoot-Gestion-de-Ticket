package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Base_Connaissance;
import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;

import java.util.List;

public interface Base_ConnaissanceService {
    Base_Connaissance CreerBase_Connaissance(Base_Connaissance base_connaissance,User Id);

    List<Base_Connaissance> lireBase_Connaissances();

    Base_Connaissance modifyBase_Connaissance( Long Id ,Base_Connaissance base_connaissance);

    String deleteBase_Connaissance(Long Id);
}
