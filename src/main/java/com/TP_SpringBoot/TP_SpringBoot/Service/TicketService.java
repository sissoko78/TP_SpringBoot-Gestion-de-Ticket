package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;

import java.util.List;


public interface TicketService {

    Ticket CreerTicket(Ticket ticket, User Id);

    List<Ticket> lireTickets();

    Ticket modifyTickets( Long Id ,Ticket ticket);

    String deleteTicket(Long Id);
}
