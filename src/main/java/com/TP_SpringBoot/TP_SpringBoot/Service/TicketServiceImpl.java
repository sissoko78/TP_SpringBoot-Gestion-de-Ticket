package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Reponse;
import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.ReponseRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    private TicketRepository ticketRepository;
    private ReponseRepository reponseRepository;
    @Override
    public Ticket CreerTicket(Ticket ticket, User apprenant) {

        //Attribuer au champ Apprenant celui qui est connecté
        ticket.setApprenant(apprenant);
        //Creer une nouvelle reponse avec l'id du ticket creer
        Reponse reponse = new Reponse();
        reponse.setTicket(ticket);
        //Sauvergarder le ticket
        Ticket newTicket = ticketRepository.save(ticket);
        //Sauvergarder la reponse vide mais avec l'id du ticket
        reponseRepository.save(reponse);
        return newTicket;
    }

    @Override
    public List<Ticket> lireTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifyTickets(Long Id, Ticket ticket) {
        return ticketRepository.findById(Id)
                .map(y->{
                    ticket.setDescription(ticket.getDescription());
                    ticket.setCategorie(ticket.getCategorie());
                    ticket.setPriorite(ticket.getPriorite());
                    return ticketRepository.save(ticket);
                        }).orElseThrow(()->new RuntimeException("La ticket n'existe pas"));
    }

    @Override
    public String deleteTicket(Long Id) {
        ticketRepository.deleteById(Id);
        return "Ticket supprimer avec sucès";
    }
}
