package com.saferide.saferide.colas;

public class Nodo {

    private String id_metrica;
    private String ubicacion;
    private String usuario;
    private int me_gusta;
    private String multimedia;
    private Nodo next;

    public Nodo(){
        this.id_metrica = "";
        this.ubicacion = "";
        this.usuario = "";
        this.me_gusta = 0;
        this.multimedia = "";
        this.next = null;
    }

    public Nodo(String id_metrica, String ubicacion, String usuario, int me_gusta, String multimedia){
        this.id_metrica = id_metrica;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
        this.me_gusta = me_gusta;
        this.multimedia = multimedia;
        this.next = null;
    }

    public String getId_metrica() {
        return id_metrica;
    }

    public void setId_metrica(String id_metrica) {
        this.id_metrica = id_metrica;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getMe_gusta() {
        return me_gusta;
    }

    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
