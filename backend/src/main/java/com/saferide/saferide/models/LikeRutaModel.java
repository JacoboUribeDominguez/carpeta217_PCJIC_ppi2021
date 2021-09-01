package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "puntuacion_ruta")
public class LikeRutaModel {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_puntuacion_ruta;
    @Column
    private String id_ruta;
    @Column
    private String id_usuario;

    public int getId_puntuacion_ruta() {
        return id_puntuacion_ruta;
    }

    public void setId_puntuacion_ruta(int id_puntuacion_ruta) {
        this.id_puntuacion_ruta = id_puntuacion_ruta;
    }

    public String getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(String id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
