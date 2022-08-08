package com.asebas.appbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleProducto")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int cantidad;

    @Column
    private double descuento;

    @Column
    private double precioVenta;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Product producto;

    @ManyToOne
    @JoinColumn(name = "listaId")
    private EventList lista;
    
}
