package com.TP_SpringBoot.TP_SpringBoot.Controller;


import com.TP_SpringBoot.TP_SpringBoot.Model.Admin;
import com.TP_SpringBoot.TP_SpringBoot.Model.Base_Connaissance;
import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.AdminRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.UserRepository;
import com.TP_SpringBoot.TP_SpringBoot.Service.AdminService;
import com.TP_SpringBoot.TP_SpringBoot.Service.Base_ConnaissanceService;
import com.TP_SpringBoot.TP_SpringBoot.Service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Administrateur",description = "API Admin")
@RequestMapping("/Admin")
@AllArgsConstructor
public class AdminController {
    private final AdminRepository adminRepository;
    private AdminService adminService;
    private FormateurService formateurService;
    private Base_ConnaissanceService base_connaissanceService;
    private UserRepository userRepository;
@Operation(summary = "CreerAdmin", description = "permet de creer un Admin")
    @PostMapping("/CreationAdmin")
    public Admin CreateAdmin(@RequestBody Admin admin) {
        return adminService.CreerAdmin(admin);
    }
    @Operation(summary = "AfficherlistedeAdmin", description = "permet de voir la liste des Admin")
    @GetMapping("/Afficher")

    public List<Admin> Read(){
        return adminRepository.findAll();
    }
    @Operation(summary = "Modification_Admin", description = "permet de modifier un Admin")
    @PutMapping("/Modification/{Id}")
    public Admin Modifier(@PathVariable Long Id,@RequestBody Admin admin){
        return adminService.modifyAdmin(Id,admin);
    }
    @Operation(summary = "Supprimer_Admin", description = "permet de supprimer un Admin")

    @DeleteMapping("/supprimer/{Id}")
    public String SupprimerAdmin(@PathVariable Long Id) {
        return adminService.deleteAdmin(Id);
    }
    /*private Admin CreerFor(Formateur formateur, String reponse) {
        Reponse rep = new Reponse();
        rep.setId(formateur.getId());
        rep.setReponse(reponse);
        return reponseService.CreerReponse(rep);*/
    @Operation(summary = "Creer_Formateur", description = "permet de creer un Formateur")
    @PostMapping("/CreerFormateur")
    public Formateur AddFormateur(@RequestBody Formateur formateur) {
        return formateurService.CreerFormateur(formateur);
    }
    @Operation(summary = "Supprimer_Formateur", description = "permet de supprimer un Formateur")
    @DeleteMapping("/Supprimer/{Id}")
    public String DeleteFormateur(@PathVariable Long Id) {
        return formateurService.deleteFormateur(Id);
    }
    @Operation(summary = "List_Formateur", description = "permet de voir  la liste des  Formateurs")

    @GetMapping("/AfficherFormateur")
    public List<Formateur> ListFormateur(){
        return formateurService.lireFormateurs();
    }
    @Operation(summary = "Ajouter_BC", description = "permet d'ajouter une Q et R dans la base de connaissance")

    @PostMapping("/CreerBC")
    public Base_Connaissance CreerBC (@RequestBody Base_Connaissance base_connaissance){
        //prendre les informations de celui qui est connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //Rechercher dans la base de données si le username existe
        User admin = userRepository.findByUsername(username);
        return base_connaissanceService.CreerBase_Connaissance(base_connaissance,admin);
    }
    @Operation(summary = "Supprimer_BC", description = "permet de supprimer une Q et R dans la base de connaissance")
    @DeleteMapping("/SupprimerBC{Id}/")
    public String DeleteBC(@PathVariable Long Id){
        return base_connaissanceService.deleteBase_Connaissance(Id);
    }

}
