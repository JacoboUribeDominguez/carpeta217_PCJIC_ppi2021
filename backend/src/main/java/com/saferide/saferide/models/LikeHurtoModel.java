package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "puntuacion_hurto")
public class LikeHurtoModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_puntuacion_hurto;
    @Column
    private String id_hurto;
    @Column
    private String id_usuario;

    public int getId_puntuacion_hurto() {
        return id_puntuacion_hurto;
    }

    public void setId_puntuacion_hurto(int id_puntuacion_hurto) {
        this.id_puntuacion_hurto = id_puntuacion_hurto;
    }

    public String getId_hurto() {
        return id_hurto;
    }

    public void setId_hurto(String id_hurto) {
        this.id_hurto = id_hurto;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
