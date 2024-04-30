package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idArticulo;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "precio")
    private Double precio;

    public Articulo() {
    }

    public Articulo(String tipo, Double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "idArticulo=" + idArticulo +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
