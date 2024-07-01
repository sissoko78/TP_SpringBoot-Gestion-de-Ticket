package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Repository.FormateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class FormateurServiceImpl implements FormateurService{
    private FormateurRepository formateurRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Formateur CreerFormateur(Formateur formateur) {
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> lireFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur modifyFormateur(Long Id, Formateur formateur) {
        return formateurRepository.findById(Id)
                .map(i->{
                    formateur.setNom(formateur.getNom());
                    formateur.setPrenom(formateur.getPrenom());
                    formateur.setEmail(formateur.getEmail());
                    formateur.setPassword(formateur.getPassword());
                    return formateurRepository.save(formateur);
                }).orElseThrow(()->new RuntimeException("Formateur non trouvable"));
    }

    @Override
    public String deleteFormateur(Long Id) {
        formateurRepository.deleteById(Id);
        return "Formateur supprimer avec succes";
    }
}
