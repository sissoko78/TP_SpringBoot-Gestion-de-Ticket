package com.TP_SpringBoot.TP_SpringBoot.Service;


import com.TP_SpringBoot.TP_SpringBoot.Enum.Statut;
import com.TP_SpringBoot.TP_SpringBoot.Model.Formateur;
import com.TP_SpringBoot.TP_SpringBoot.Model.Reponse;
import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.ReponseRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReponseSerciveImpl implements ReponseService{
    private TicketRepository ticketRepository;
    private ReponseRepository reponseRepository;
    private MailSender mailSender;

    @Override
    public Reponse CreerReponse(String reponse, User formateur,Long idTicket) {
        //Rechercher le ticket dans la base de données a partir de l'id donné en parametre
        Ticket ticket = ticketRepository.getReferenceById(idTicket);
        ticket.setStatut(Statut.Resolu);
        //prendre l'attribut de la reponse se trouvant dans le ticket
        User apprenant = ticket.getApprenant();
        String email = apprenant.getEmail();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(apprenant.getUsername()+" Votre ticket a été repondu");
        message.setText("la reponse est :\n\n" + ticket.getReponse());
        mailSender.send(message);
        Reponse repon = ticket.getReponse();
        repon.setFormateur((Formateur) formateur);
        repon.setReponse(reponse);
        return reponseRepository.save(repon);
    }

    @Override
    public List<Reponse> lireReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse modifyReponse(Long Id, Reponse reponse) {
        return reponseRepository.findById(Id)
                .map(z->{
                    reponse.setReponse(reponse.getReponse());
                    return reponseRepository.save(reponse);
                }).orElseThrow(()->new RuntimeException("Réponse non trouvable"));
    }

    @Override
    public String deleteReponse(Long Id) {
        reponseRepository.deleteById(Id);
        return "La réponse a été supprimer avec succès";
    }
    /*private Reponse RepondreTicket(int ticketId, String reponse) {
        Ticket ticket = ticketRepository.findBy(ticketId);

    }*/
}
