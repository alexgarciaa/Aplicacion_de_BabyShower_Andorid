package com.asebas.appbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bebe")
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String primerNombre;
    
    @Column
    private String segundoNombre;

    @Column(nullable = false)
    private String primerApellido;

    @Column(nullable = false)
    private String segundoApellido;

    @Column(nullable = false)
    private String fechaEstNac;

    @Column(nullable = false)
    private String sexo;

    @OneToOne(mappedBy = "bebe")
    private Event evento;

    @ManyToOne
    @JoinColumn(name = "padreId", nullable = false)
    private Father padre;
    
    @ManyToOne
    @JoinColumn(name = "madreId", nullable = false)
    private Mother madre;

    public Baby() {}

    public Baby(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
            String fechaEstNac, String sexo, Father padre, Mother madre) {
        super();
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaEstNac = fechaEstNac;
        this.sexo = sexo;
        this.padre = padre;
        this.madre = madre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaEstNac() {
        return fechaEstNac;
    }

    public void setFechaEstNac(String fechaEstNac) {
        this.fechaEstNac = fechaEstNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Father getPadre() {
        return padre;
    }

    public void setPadre(Father padre) {
        this.padre = padre;
    }

    public Mother getMadre() {
        return madre;
    }

    public void setMadre(Mother madre) {
        this.madre = madre;
    }

}
