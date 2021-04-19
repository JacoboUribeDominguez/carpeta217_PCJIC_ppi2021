package com.saferide.saferide.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id
    @Column(unique = true, nullable = false)
    private int codigo;
    private String nombre;
    private String correo;
    private String contrasena;


    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

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
}
