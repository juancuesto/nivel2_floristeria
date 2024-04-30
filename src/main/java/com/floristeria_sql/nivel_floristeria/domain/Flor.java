package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "flor")
public class Flor extends Articulo{

    @Column(name = "color")
    private String color;

    public Flor() {
    }

    public Flor(String tipo, Double precio, String color) {
        super(tipo, precio);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
