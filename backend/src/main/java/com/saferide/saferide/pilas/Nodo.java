package com.saferide.saferide.pilas;

public class Nodo {

    //atributos
    private String id_ruta;
    private String multimedia;
    private String id_usuario;
    private String usuario;
    private int me_gusta;
    private String ubicacion;
    private boolean isLiked;
    private Nodo next;

    //Constructor 1 nodo en cuerpo
    public Nodo(
            String id_ruta,
            String multimedia,
            String id_usuario,
            String usuario,
            int me_gusta,
            String ubicacion,
            Nodo next)
    {
        this.id_ruta = id_ruta;
        this.multimedia = multimedia;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.me_gusta = me_gusta;
        this.ubicacion = ubicacion;
        this.next = next;
    }

    //Constructor 2 nodo no identificado
    public Nodo(
            String id_ruta,
            String multimedia,
            String id_usuario,
            String usuario,
            int me_gusta,
            String ubicacion)
    {
        this.id_ruta = id_ruta;
        this.multimedia = multimedia;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.me_gusta = me_gusta;
        this.ubicacion = ubicacion;
        this.next = null;
    }

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

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
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

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
