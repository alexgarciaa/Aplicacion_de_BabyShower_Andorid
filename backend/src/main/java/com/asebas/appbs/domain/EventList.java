package com.asebas.appbs.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lista")
public class EventList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double precioTotal;

    @OneToMany(mappedBy = "lista")
    private List<ProductDetail> detalleProductos;

    @OneToOne
    @JoinColumn(name = "eventoId")
    private Event evento;

    public EventList() {}

    public EventList(double precioTotal, Event evento) {
        super();
        this.precioTotal = precioTotal;
        this.evento = evento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public List<ProductDetail> getDetalleProductos() {
        return detalleProductos;
    }
    
}
