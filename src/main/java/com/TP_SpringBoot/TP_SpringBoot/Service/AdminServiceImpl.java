package com.TP_SpringBoot.TP_SpringBoot.Service;


import com.TP_SpringBoot.TP_SpringBoot.Model.Admin;
import com.TP_SpringBoot.TP_SpringBoot.Repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Admin CreerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }




    @Override
    public List<Admin> lire() {
        return adminRepository.findAll();
    }

    @Override
    public Admin modifyAdmin(Long Id, Admin admin) {
        return adminRepository.findById(Id)
                .map(p->{
                    admin.setNom(admin.getNom());
                    admin.setPrenom(admin.getPrenom());
                    admin.setEmail(admin.getEmail());
                    admin.setPassword(admin.getPassword());
                    return adminRepository.save(admin);
                }).orElseThrow(()->new RuntimeException("Administrateur non trouvable"));
    }

    @Override
    public String deleteAdmin(Long Id) {
        adminRepository.deleteById(Id);
        return "Administrateur supprimer avec succes";
    }
}
