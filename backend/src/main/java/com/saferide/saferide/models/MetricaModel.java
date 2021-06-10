package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "metrica")
public class MetricaModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id_metrica;

    @Column
    private float tiempo;

    @Column
    private String id_usuario;

    @Column
    private String id_ruta;

    public String getId_tiempo() {
        return id_metrica;
    }

    public void setId_tiempo(String id_metrica) {
        this.id_metrica = id_metrica;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(String id_ruta) {
        this.id_ruta = id_ruta;
    }
}
