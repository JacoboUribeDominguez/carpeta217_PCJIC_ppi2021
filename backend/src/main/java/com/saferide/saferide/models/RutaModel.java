package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "ruta")
public class RutaModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id_ruta;
    @Column
    private String multimedia;
    @Column
    private String id_usuario;
    @Column
    private int me_gusta;
    @Column
    private String ubicacion;

    public String getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(String id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getMe_gusta() {
        return me_gusta;
    }

    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
