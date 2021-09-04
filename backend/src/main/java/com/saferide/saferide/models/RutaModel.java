package com.saferide.saferide.models;

import javax.persistence.*;
/**
 * Clase que determina el modelo y apunta a los campos en la base de datos.
 */
@Entity
@Table(name = "ruta")
public class RutaModel {
    /**
     * Se definen las variables apuntando a cada una de las columnas de las bases de datos,
     * tomando en cuenta llaves primarias y foraneas
     */
    @Id
    @Column(unique = true, nullable = false)
    private String id_ruta;
    @Column
    private String multimedia;
    /**
     * Se define la variable id_usuario apuntando a la clase "UserModel" para mantener la
     * misma relación tanto en Springboot como en SQL
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserModel id_usuario;

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
