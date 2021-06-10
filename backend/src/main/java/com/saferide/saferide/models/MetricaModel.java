package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "metrica")
public class MetricaModel {

    @Id
    @Column(name ="id_metrica", unique = true, nullable = false)
    private String id_metrica;

    //@Column(name = "id_usuario")
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private UserModel id_usuario;

    //@Column(name = "id_ruta")
    @ManyToOne
    @JoinColumn(name="id_ruta")
    private RutaModel id_ruta;

    public String getId_metrica() {
        return id_metrica;
    }

    public void setId_metrica(String id_metrica) {
        this.id_metrica = id_metrica;
    }

    public UserModel getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UserModel id_usuario) {
        this.id_usuario = id_usuario;
    }

    public RutaModel getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(RutaModel id_ruta) {
        this.id_ruta = id_ruta;
    }
}
