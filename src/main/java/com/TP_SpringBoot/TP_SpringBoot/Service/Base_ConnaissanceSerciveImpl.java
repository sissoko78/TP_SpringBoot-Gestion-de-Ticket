package com.TP_SpringBoot.TP_SpringBoot.Service;


import com.TP_SpringBoot.TP_SpringBoot.Model.Admin;
import com.TP_SpringBoot.TP_SpringBoot.Model.Base_Connaissance;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.Base_ConnaissanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Base_ConnaissanceSerciveImpl implements Base_ConnaissanceService {
    private Base_ConnaissanceRepository base_connaissanceRepository;


    @Override
    public Base_Connaissance CreerBase_Connaissance(Base_Connaissance base_connaissance, User admin) {
        base_connaissance.setAdmin((Admin) admin);
        return base_connaissanceRepository.save(base_connaissance);
    }

    @Override
    public List<Base_Connaissance> lireBase_Connaissances() {
        return base_connaissanceRepository.findAll();
    }

    @Override
    public Base_Connaissance modifyBase_Connaissance(Long Id, Base_Connaissance base_connaissance) {
        return base_connaissanceRepository.findById(Id)
                .map (b->{
                    base_connaissance.setQuestion(base_connaissance.getQuestion());
                    base_connaissance.setReponse(base_connaissance.getReponse());
                    return base_connaissanceRepository.save(base_connaissance);
        }).orElseThrow(()->new RuntimeException("Question et Reponse dans la Base de connaissance non trouvable"));
    }

    @Override
    public String deleteBase_Connaissance(Long Id) {
        base_connaissanceRepository.deleteById(Id);
        return "Question et Réponse supprimer avec succès de la Base de connaissance";
    }
}
