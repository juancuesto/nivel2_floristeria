package com.floristeria_sql.nivel_floristeria.service;

import com.floristeria_sql.nivel_floristeria.Exception.NotFoundException;
import com.floristeria_sql.nivel_floristeria.domain.Ticket;
import com.floristeria_sql.nivel_floristeria.repositori.TicketRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepositori ticketRepositori;
    @Override
    public Ticket crearTicket(Ticket ticket) {
        return ticketRepositori.save(ticket);
    }

    @Override
    public Optional<Ticket> buscarTicketById(Long id) {
        Optional<Ticket> ticketOptional=ticketRepositori.findById(id);
        if (ticketOptional.isEmpty()){
            throw new NotFoundException("p-404", HttpStatus.NOT_FOUND,"No se ha encontrado el ticket");
        }
        return ticketOptional;
    }

    @Override
    public Ticket actualizarTicket(Ticket ticket, Long id) {
        Optional<Ticket> ticketOptional=ticketRepositori.findById(id);
        if (ticketOptional.isEmpty()){
            throw new NotFoundException("p-404", HttpStatus.NOT_FOUND,"No se ha encontrado el ticket a actualizar");
        }
        ticketOptional.get().setListaArticulos(ticket.getListaArticulos());
        return ticketRepositori.save(ticketOptional.get());
    }

    @Override
    public List<Ticket> listarTickets() {
        List<Ticket> listadoTickets=ticketRepositori.findAll();
        if (listadoTickets.isEmpty()){
            throw new NotFoundException("p-404",HttpStatus.NOT_FOUND,"No hay listado de tickets que mostrar");
        }
        return listadoTickets;
    }

    @Override
    public void borrarTicketById(Long id) {
        Optional<Ticket> ticketOptional=ticketRepositori.findById(id);
        if (ticketOptional.isEmpty()){
            throw new NotFoundException("p-404", HttpStatus.NOT_FOUND,"No se ha encontrado el ticket a borrar");
        }
        ticketRepositori.deleteById(id);
    }

    @Override
    public void borrarAllTickets() {
        ticketRepositori.deleteAll();
    }
}
