package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "puntuacion_sendero")
public class LikeSenderoModel {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_puntuacion_sendero;
    @Column
    private String id_sendero;
    @Column
    private String id_usuario;

    public int getId_puntuacion_sendero() {
        return id_puntuacion_sendero;
    }

    public void setId_puntuacion_sendero(int id_puntuacion_sendero) {
        this.id_puntuacion_sendero = id_puntuacion_sendero;
    }

    public String getId_sendero() {
        return id_sendero;
    }

    public void setId_sendero(String id_sendero) {
        this.id_sendero = id_sendero;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}

