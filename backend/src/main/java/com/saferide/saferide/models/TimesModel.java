package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "tiempo_metrica")
public class TimesModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_tiempo;

    @Column
    private String id_metrica;

    @Column
    private double tiempo;

    public int getId_tiempo() {
        return id_tiempo;
    }

    public void setId_tiempo(int id_tiempo) {
        this.id_tiempo = id_tiempo;
    }

    public String getId_metrica() {
        return id_metrica;
    }

    public void setId_metrica(String id_metrica) {
        this.id_metrica = id_metrica;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
}
