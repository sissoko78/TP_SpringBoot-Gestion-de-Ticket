package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Model.Reponse;
import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;

import java.util.List;

public interface ReponseService {
    //Reponse CreerReponse(Reponse reponse);

    Reponse CreerReponse(String reponse,User formateur, Long idTicket);

    List<Reponse> lireReponse();

    Reponse modifyReponse( Long Id ,Reponse reponse);

    String deleteReponse(Long Id);
}
