package com.floristeria_sql.nivel_floristeria.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "decoracion")
public class Decoracion extends Articulo{

    @Column(name = "matrial")
    private Material material;

    public Decoracion() {
    }

    public Decoracion(String tipo, Double precio, Material material) {
        super(tipo, precio);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    @Override
    public String toString() {
        return "Decoracion{" +
                "material=" + material +
                "} " + super.toString();
    }
}
