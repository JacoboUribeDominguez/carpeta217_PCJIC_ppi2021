package com.saferide.saferide.listas;


import com.saferide.saferide.models.UserModel;
import org.apache.catalina.User;

public class Nodo {

    //atributos
    private String id_ruta;
    private String multimedia;
    private UserModel id_usuario;
    private int me_gusta;
    private String ubicacion;
    private Nodo next;
    private Nodo previous;

    //Constructor 1 nodo en cuerpo
    public Nodo(
            String id_ruta,
            String multimedia,
            UserModel id_usuario,
            int me_gusta,
            String ubicacion,
            Nodo next,
            Nodo previous)
    {
        this.id_ruta = id_ruta;
        this.multimedia = multimedia;
        this.id_usuario = id_usuario;
        this.me_gusta = me_gusta;
        this.ubicacion = ubicacion;
        this.next = next;
        this.previous = previous;
    }

    //Constructor 2 primer nodo
    public Nodo(
            String id_ruta,
            String multimedia,
            UserModel id_usuario,
            int me_gusta,
            String ubicacion,
            Nodo next)
    {
        this.id_ruta = id_ruta;
        this.multimedia = multimedia;
        this.id_usuario = id_usuario;
        this.me_gusta = me_gusta;
        this.ubicacion = ubicacion;
        this.next = next;
        this.previous = null;
    }

    //Constructor 2 nodo no identificado
    public Nodo(
            String id_ruta,
            String multimedia,
            UserModel id_usuario,
            int me_gusta,
            String ubicacion)
    {
        this.id_ruta = id_ruta;
        this.multimedia = multimedia;
        this.id_usuario = id_usuario;
        this.me_gusta = me_gusta;
        this.ubicacion = ubicacion;
        this.next = null;
        this.previous = null;
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

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
}
