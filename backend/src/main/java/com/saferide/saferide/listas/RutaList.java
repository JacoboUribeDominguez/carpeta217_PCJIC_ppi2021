package com.saferide.saferide.listas;

import com.saferide.saferide.models.RutaModel;

import java.util.List;

public class RutaList {

    //atributos
    private Nodo first;
    private Nodo last;

    //constructor
    public RutaList(){
        this.first = this.last = null;
    }

    //metodos
        //llenar lista
    public void fillList(List<RutaModel> rutas){
        RutaModel tempRuta;
        for (int i = 0; i < rutas.size(); i++){
            tempRuta = rutas.get(i);
            this.addList(new Nodo(tempRuta.getId_ruta(), tempRuta.getMultimedia(), tempRuta.getId_usuario(), tempRuta.getMe_gusta(), tempRuta.getUbicacion()));
        }
    }
        //agregar a lista
    public void addList(Nodo nodo){
        if(this.first == null){
            this.first = nodo;
        } else if (this.last == null) {
            this.first.setNext(nodo);
            this.last = nodo;
            this.last.setPrevious(this.first);
        } else {
            this.last.setNext(nodo);
            nodo.setPrevious(this.last);
            this.last = nodo;
        }
    }

    public void showList(){
        Nodo temp = this.first;
        while(temp != null){
            System.out.print("["+temp.getUbicacion()+"]");
            temp = temp.getNext();
        }
        System.out.println("");
    }
}
