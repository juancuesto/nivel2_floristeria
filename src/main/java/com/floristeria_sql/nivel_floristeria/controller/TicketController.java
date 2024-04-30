package com.floristeria_sql.nivel_floristeria.controller;

import com.floristeria_sql.nivel_floristeria.domain.Ticket;
import com.floristeria_sql.nivel_floristeria.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/floristeria")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/crear_ticket")
    public ResponseEntity<?> crearTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<>(ticketService.crearTicket(ticket), HttpStatus.CREATED);
    }
    @GetMapping("/buscar_ticket/{id}")
    public ResponseEntity<?> buscarTicket(@PathVariable Long id){
        Optional<Ticket> ticketOptional=ticketService.buscarTicketById(id);
        if (ticketOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado el ticket",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketOptional,HttpStatus.FOUND);
    }
    @GetMapping("/listar_tickets")
    public ResponseEntity<?> listarTickets(){
        List<Ticket> listadoTickets=ticketService.listarTickets();
        if (listadoTickets.isEmpty()){
            return new ResponseEntity<>("No se han encontrado tickets",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listadoTickets,HttpStatus.OK);
    }
    @PutMapping("/actualizar_ticket/{id}")
    public ResponseEntity<?>  actualizarTicket(@RequestBody Ticket ticket,@PathVariable Long id){
        Optional<Ticket> ticketOptional=ticketService.buscarTicketById(id);
        if (ticketOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado el ticket a actualizar",HttpStatus.NOT_FOUND);
        }
        ticketOptional.get().setListaArticulos(ticket.getListaArticulos());
        return new ResponseEntity<>(ticketService.crearTicket(ticketOptional.get()),HttpStatus.OK);
    }
    @DeleteMapping("/borrar_ticket")
    public ResponseEntity<?> borrarTicketById(@PathVariable Long id){
        Optional<Ticket> ticketOptional=ticketService.buscarTicketById(id);
        if (ticketOptional.isEmpty()){
            return new ResponseEntity<>("No se ha encontrado el ticket a borrar",HttpStatus.NOT_FOUND);
        }
        ticketService.borrarTicketById(id);
        return new ResponseEntity<>("el ticket se ha borrado correctamente",HttpStatus.OK);
    }
    @DeleteMapping("/borrar_todo")
    public ResponseEntity<?> borrarAllTickets(){
        ticketService.borrarAllTickets();
        return new ResponseEntity<>("Se han borrado todos los tickets correctamente",HttpStatus.OK);
    }
}
