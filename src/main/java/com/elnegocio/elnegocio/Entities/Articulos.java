package com.elnegocio.elnegocio.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String fecha;
    private String titulo;
    private String parrafos;
    private boolean esInvitado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getParrafos() {
        return parrafos;
    }

    public void setParrafos(String parrafos) {
        this.parrafos = parrafos;
    }

    public boolean isEsInvitado() {
        return esInvitado;
    }

    public void setEsInvitado(boolean esInvitado) {
        this.esInvitado = esInvitado;
    }

}
