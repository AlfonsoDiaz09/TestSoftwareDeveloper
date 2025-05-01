package com.example.TestSoftwareDeveloper.model;

import jakarta.persistence.*;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Factura(){}

    public Factura (String fecha, Double monto, Persona persona) {
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}