package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Apprenant;
import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Repository.ApprenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class ApprenantServiceImpl implements ApprenantService{

    private ApprenantRepository apprenantRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public Apprenant CreerApprenant(Apprenant apprenant) {
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> lireApprenants() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant modifyApprenant(Long Id, Apprenant apprenant) {
        return apprenantRepository.findById(Id)
                .map(x->{
                    apprenant.setNom(apprenant.getNom());
                    apprenant.setPrenom(apprenant.getPrenom());
                    apprenant.setEmail(apprenant.getEmail());
                    apprenant.setPassword(apprenant.getPassword());
                    return apprenantRepository.save(apprenant);
                }).orElseThrow(()->new RuntimeException("Apprenant non trouvable"));
    }



    @Override
    public String deleteApprenant(Long Id) {
        apprenantRepository.deleteById(Id);
        return "Apprenant supprimer avec succes";
    }
}
