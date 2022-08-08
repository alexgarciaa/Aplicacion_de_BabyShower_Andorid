package com.asebas.appbs.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descripcion;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column
    private String imagen;

    @Column
    private double precio;

    @Column
    private double precioBs;

    @OneToMany(mappedBy = "producto")
    private List<ProductDetail> detalleProducto;

    public Product() {}

    public Product(String descripcion, String codigo, String imagen, double precio, double precioBs) {
        super();
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.imagen = imagen;
        this.precio = precio;
        this.precioBs = precioBs;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioBs() {
        return precioBs;
    }

    public void setPrecioBs(double precioBs) {
        this.precioBs = precioBs;
    }
}
