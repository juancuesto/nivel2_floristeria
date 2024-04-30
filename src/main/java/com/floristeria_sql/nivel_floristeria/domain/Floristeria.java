package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "floristeria")
public class Floristeria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idFloristeria;
    @Column(name = "nombre")
    private String nombre;
    private List<Articulo> stockTienda;
    @OneToMany(mappedBy = "floristeria")
    private List<Ticket> historicoVentas;

    public Floristeria(String nombre) {
        this.nombre = nombre;
        stockTienda=new ArrayList<>();
        historicoVentas=new ArrayList<>();
    }

    public Long getId() {
        return idFloristeria;
    }

    public void setId(Long id) {
        this.idFloristeria = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Articulo> getStockTienda() {
        return stockTienda;
    }

    public void setStockTienda(List<Articulo> stockTienda) {
        this.stockTienda = stockTienda;
    }

    public List<Ticket> getHistoricoVentas() {
        return historicoVentas;
    }

    public void setHistoricoVentas(List<Ticket> historicoVentas) {
        this.historicoVentas = historicoVentas;
    }

    @Override
    public String toString() {
        return "Floristeria{" +
                "id=" + idFloristeria +
                ", nombre='" + nombre + '\'' +
                ", stockTienda=" + stockTienda +
                ", historicoVentas=" + historicoVentas +
                '}';
    }
}
