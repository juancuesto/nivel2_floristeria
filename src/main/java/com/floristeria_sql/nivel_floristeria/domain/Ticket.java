package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idTicket;
    private List<Articulo> listaArticulos;
    @ManyToOne
    @JoinColumn(name = "floristeria",referencedColumnName = "idFloristeria")
    private Floristeria floristeria;

    public Ticket(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public Long getId() {
        return idTicket;
    }

    public void setId(Long id) {
        this.idTicket = id;
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + idTicket +
                ", listaArticulos=" + listaArticulos +
                '}';
    }
}
