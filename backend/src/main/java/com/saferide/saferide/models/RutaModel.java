package com.saferide.saferide.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ruta")
public class RutaModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id_ruta;

    @Column
    private String multimedia;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private UserModel id_usuario;

    @Column
    private int me_gusta;
    @Column
    private String ubicacion;

    @OneToMany(mappedBy = "id_ruta", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<MetricaModel> metricaList;

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

    public UserModel getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UserModel id_usuario) {
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
