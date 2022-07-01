/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author danie
 */
@Entity
@Table(name="conciertos")
public class Concierto implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private int costo_evento;
    private String fecha;
    private int capacidad_max_personas;
    private String lugar;
    
    @ManyToOne
    @JoinColumn(name="artistas_id")
    private Artista artista;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCosto_evento() {
        return costo_evento;
    }

    public void setCosto_evento(int costo_evento) {
        this.costo_evento = costo_evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad_max_personas() {
        return capacidad_max_personas;
    }

    public void setCapacidad_max_personas(int capacidad_max_personas) {
        this.capacidad_max_personas = capacidad_max_personas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    
    
}
