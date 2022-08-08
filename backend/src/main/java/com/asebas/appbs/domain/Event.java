package com.asebas.appbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String direccion;

    @Column
    private String fecha;

    @OneToOne
    @JoinColumn(name = "bebeId")
    private Baby bebe;

    @OneToOne(mappedBy = "evento")
    private EventList lista;

    public Event() {}

    public Event(String direccion, String fecha, Baby bebe) {
        super();
        this.direccion = direccion;
        this.fecha = fecha;
        this.bebe = bebe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Baby getBebe() {
        return bebe;
    }

    public void setBebe(Baby bebe) {
        this.bebe = bebe;
    }

}
