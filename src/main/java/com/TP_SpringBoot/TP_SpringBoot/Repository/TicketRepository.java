package com.TP_SpringBoot.TP_SpringBoot.Repository;

import com.TP_SpringBoot.TP_SpringBoot.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
