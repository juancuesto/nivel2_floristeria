package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "arboles")
public class Arbol extends Articulo {
    @Column(name = "altura")
    private Double altura;

    public Arbol(String tipo, Double precio, Double altura) {
        super(tipo, precio);
        this.altura = altura;
    }

    public Arbol() {
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "altura=" + altura +
                "} " + super.toString();
    }
}
