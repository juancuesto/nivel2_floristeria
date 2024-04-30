package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket crearTicket(Ticket ticket);
    Optional<Ticket> buscarTicketById(Long id);
    Ticket actualizarTicket(Ticket ticket,Long id);
    List<Ticket> listarTickets();
    void borrarTicketById(Long id);
    void borrarAllTickets();
}
