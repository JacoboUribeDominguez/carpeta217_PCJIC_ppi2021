package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "hurto")
public class HurtoModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id_hurto;
    @Column
    private String multimedia;
    @Column
    private String ubicacion;
    @Column
    private String modalidad_hurto;
    @Column
    private String id_usuario;

    public String getId_hurto() {
        return id_hurto;
    }

    public void setId_hurto(String id_hurto) {
        this.id_hurto = id_hurto;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getModalidad_hurto() {
        return modalidad_hurto;
    }

    public void setModalidad_hurto(String modalidad_hurto) {
        this.modalidad_hurto = modalidad_hurto;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
