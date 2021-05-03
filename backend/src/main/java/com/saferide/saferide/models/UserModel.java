package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UserModel {

    @Id
    @Column(unique = true, nullable = false)
    private int id_usuario;
    @Column
    private String nombre;
    @Column
    private String usuario;
    @Column
    private String correo;
    @Column
    private String contrasena;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getContrasena(){
        return this.contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
