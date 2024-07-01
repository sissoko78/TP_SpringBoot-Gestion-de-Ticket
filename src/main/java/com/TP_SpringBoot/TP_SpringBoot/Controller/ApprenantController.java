package com.TP_SpringBoot.TP_SpringBoot.Controller;


import com.TP_SpringBoot.TP_SpringBoot.Model.*;
import com.TP_SpringBoot.TP_SpringBoot.Repository.ApprenantRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.UserRepository;
import com.TP_SpringBoot.TP_SpringBoot.Service.ApprenantService;
import com.TP_SpringBoot.TP_SpringBoot.Service.Base_ConnaissanceService;
import com.TP_SpringBoot.TP_SpringBoot.Service.NotificationService;
import com.TP_SpringBoot.TP_SpringBoot.Service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.TransactionExecutionListener;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@Tag(name = "Apprenant",description = "API apprenant")
@RestController
@RequestMapping("/Apprenant")
@AllArgsConstructor
public class ApprenantController {
    private final ApprenantRepository apprenantRepository;
    private ApprenantService apprenantService;
    private TicketService ticketService;
    private UserRepository userRepository;
    private NotificationService notificationService;
    private Base_ConnaissanceService base_connaissanceService;

    /*@PostMapping("/CreerApprenant")
    public Apprenant CreerApprenant(@RequestBody Apprenant apprenant) {

        return apprenantService.CreerApprenant(apprenant);
    }
    @GetMapping("/VoirApprenant")
    public List<Apprenant> LireApprenant() {
        return apprenantService.lireApprenants();
    }
    @PutMapping("/ModifierApprenant/{Id}")
    public Apprenant ModifApprenant(@PathVariable Long Id, @RequestBody Apprenant apprenant) {
        return apprenantService.modifyApprenant(Id,apprenant);
    }
    @DeleteMapping("/SupprimerApprenant/{Id}")
    public String DeletApprenant(@PathVariable Long Id) {
        return apprenantService.deleteApprenant(Id);
    }*/
    @Operation(summary = "Ajouter_Ticket", description = "permet de creer un Ticket")
    @PostMapping("/SoumettreTicket")
    public Ticket CreerTicket (@RequestBody Ticket ticket){
        //prendre les informations de celui qui est connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //Rechercher dans la base de données si le username existe
        User apprenant = userRepository.findByUsername(username);
        // Création de la notification avec les informations pertinentes
        Notification notification = new Notification();
        notification.setTitre("Reception d'un nouveau Ticket");
        notification.setCorps("Un apprenant a soumi un nouveau Ticket ");

        // Envoi de l'email aux formateurs
        notificationService.EnvoyerFormateur(notification);

        return ticketService.CreerTicket(ticket,apprenant);
    }
    @Operation(summary = "Supprimer_Ticket", description = "permet de supprimer un Ticket")
    @DeleteMapping("/deleteTicket/{Id}")
    public String DeleteTicket (@PathVariable Long Id){
        return ticketService.deleteTicket(Id);
    }
    @Operation(summary = "Liste_Ticket", description = "permet de voir liste des Tickets")
    @GetMapping("/AfficherTicket")
    public List<Ticket> VoirListeTicket(){
        return ticketService.lireTickets();
    }
    @Operation(summary = "Voir_BC", description = "permet de voir les  Q et les R dans la base de connaissance")

    @GetMapping("/AfficherBC")
    public List<Base_Connaissance> VoirBC(){
        return base_connaissanceService.lireBase_Connaissances();
    }

}
