package com.saferide.saferide.colas;

import com.saferide.saferide.models.MetricaModel;

public class ListMetricasColas {

    private Nodo first;
    private Nodo last;

    public ListMetricasColas() {
        this.first = this.last = null;
    }

    //MÉTODOS

    public void addElement(Nodo nodo) {
        if(this.first == null){
            this.first = this.last = nodo;
        } else {
            nodo.setNext(this.first);
            this.first = nodo;
        }
    }

    public void addElement(MetricaModel metrica){
        this.addElement(new Nodo(metrica.getId_ruta().getUbicacion(), metrica.getId_usuario().getUsuario(), metrica.getId_ruta().getMe_gusta(), metrica.getId_ruta().getMultimedia()));
    }

    public void removeElement(){
        Nodo temp = this.first;
        while(temp != null){
            if(temp.getNext().getNext() == null){
                temp.setNext(null);
                this.last = temp;
                break;
            }
            temp = temp.getNext();
        }
    }

    public void show(){
        Nodo temp = this.first;
        while(temp != null){
            System.out.print("["+temp.getUsuario()+"]");
            temp = temp.getNext();
        }
    }

    //GETTERS Y SETTERS

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }
}
