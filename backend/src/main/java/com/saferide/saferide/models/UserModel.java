package com.saferide.saferide.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UserModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id_usuario;
    @Column
    private String nombre;
    @Column
    private String usuario;
    @Column
    private String correo;
    @Column
    private String contraseña;

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

    public String getContraseña(){
        return this.contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
