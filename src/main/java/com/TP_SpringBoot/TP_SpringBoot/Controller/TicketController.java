package com.TP_SpringBoot.TP_SpringBoot.Controller;

import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import com.TP_SpringBoot.TP_SpringBoot.Service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
@AllArgsConstructor

public class TicketController {
    private TicketService ticketService;
    /*public Ticket CreateTicket(@RequestBody Ticket ticket) {
        return ticketService.CreerTicket(ticket);
    }*/
    @PutMapping("/ModifierTicket/{Id}")
    private Ticket ModifierTicket(@PathVariable Long Id, @RequestBody Ticket ticket) {
        return ticketService.modifyTickets(Id, ticket);
    }

    @DeleteMapping("/DeleteTicket/{Id}")
    private String DeleteTicket(@PathVariable Long Id) {

        return ticketService.deleteTicket(Id);
    }
    @GetMapping("/VoirListeTicket")
    private List<Ticket> ReadTicket(){
        return ticketService.lireTickets();
    }



}
