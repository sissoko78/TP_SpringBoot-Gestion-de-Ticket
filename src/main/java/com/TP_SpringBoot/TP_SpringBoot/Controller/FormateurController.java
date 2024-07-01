package com.TP_SpringBoot.TP_SpringBoot.Controller;

import com.TP_SpringBoot.TP_SpringBoot.Enum.Statut;
import com.TP_SpringBoot.TP_SpringBoot.Model.*;
import com.TP_SpringBoot.TP_SpringBoot.Repository.TicketRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.UserRepository;
import com.TP_SpringBoot.TP_SpringBoot.Service.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.TP_SpringBoot.TP_SpringBoot.Enum.Statut.Resolu;
@Tag(name = "Apprenant",description = "API apprenant")

@AllArgsConstructor
@RestController
@RequestMapping("/Formateur")
public class FormateurController {

        private final TicketRepository ticketRepository;
        private ReponseService reponseService;
        private ApprenantService apprenantService;
        private UserRepository userRepository;
        private TicketService ticketService;
        /*private FormateurService formateurService;
        @PostMapping("/CreationFormateur")
        public Formateur CreateFormateur(@RequestBody Formateur formateur) {
            return formateurService.CreerFormateur(formateur);
        }
        @PutMapping("/ModifierFormateur/{Id}")
        public Formateur ModifierFormateur(@PathVariable Long Id, @RequestBody Formateur formateur) {
         return formateurService.modifyFormateur(Id, formateur);
        }
        @GetMapping("/Lireformateur")
        public List<Formateur> Read() {
        return formateurService.lireFormateurs();
    }
        @DeleteMapping("/DeleteFormateur/{Id} ")
        public String SupprimerFormateur(@PathVariable Long Id) {
        return formateurService.deleteFormateur(Id);
    }


        /*@PostMapping("RepondreTicket")
        private Reponse RepondreTicket(Formateur formateur, String reponse) {
            Reponse rep = new Reponse();
            rep.setId(formateur.getId());
            rep.setReponse(reponse);
            return reponseService.CreerReponse(rep);
        }*/

    @Operation(summary = "Ajouter_Apprenant", description = "permet de creer un apprenant")
        @PostMapping("/CreationApprenant")
    public Apprenant CreateApprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.CreerApprenant(apprenant);
    }
    @Operation(summary = "Modifier_Apprenant", description = "permet de modifier un apprenant")
    @PutMapping("/ModifierApprenant/{Id}")
    public Apprenant ModifierApprenant(@PathVariable Long Id, @RequestBody Apprenant apprenant) {
        return apprenantService.modifyApprenant(Id, apprenant);
    }
    @Operation(summary = "Voir_Liste_Apprenant", description = "permet de voir la liste des Apprenants")
    @GetMapping("/LireApprenant")
    public List<Apprenant> ListeApprenant() {
        return apprenantService.lireApprenants();
    }
    @Operation(summary = "RepondreTicket", description = "permet de repondre un Ticket")
    @PostMapping("/CreationReponse")
    private Reponse CreationReponse(@RequestBody String reponse, @RequestParam Long idTicket, Ticket ticket){
        //prendre les informations de celui qui est connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //Rechercher dans la base de données si le username existe
        User formateur = userRepository.findByUsername(username);

        return reponseService.CreerReponse(reponse,formateur,idTicket);
    }
    @Operation(summary = "Voir_Ticket", description = "permet de voir la liste des Tickets")
    @GetMapping("/VoirTicket")
    public List<Ticket>VoirTicket(){
        return ticketService.lireTickets();
    }
}
