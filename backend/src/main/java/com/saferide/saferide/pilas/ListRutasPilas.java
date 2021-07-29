package com.saferide.saferide.pilas;


import com.saferide.saferide.models.RutaModel;

import java.util.List;

public class ListRutasPilas {
    //atributos
    private Nodo first;
    private Nodo last;

    //constructor
    public ListRutasPilas(){
        this.first = this.last = null;
    }

    //metodos

    /***
     *
     * Llenar pila
     *
     */
        //llenar pila con una lista
    public void fillList(List<RutaModel> rutas){
        for (int i = 0; i < rutas.size(); i++){
            this.addElement(this.createNodo(rutas.get(i)));
        }
    }

    //llenar pila con una lista y un límite
    public void fillList(List<RutaModel> rutas, int lim){
        for (int i = lim-1; i > 0; i--){
            this.addElement( this.createNodo(rutas.get(i)));
        }
    }

        //llenar pila con otra pila
    public void fillList(ListRutasPilas rutas){
        Nodo temp = rutas.getFirst();
        while(temp != null){
            this.addElement(this.createNodo(temp));
            temp = temp.getNext();
        }
    }

        //llenar pila con otra pila y un limite de ingreso
    public void fillList(ListRutasPilas rutas, int lim){
        Nodo arrayTemp[] = new Nodo[lim];
        Nodo temp = rutas.getFirst();
        int count = 0;
        //llenamos un arreglo
        while(temp != null && count < lim){
            arrayTemp[count] = this.createNodo(temp);
            temp = temp.getNext();
            count = count + 1;
        }
        //lo guardamos con el arreglo inverso
        for (int i = lim-1; i > -1;i--){
            if(arrayTemp[i] != null ){
                this.addElement(arrayTemp[i]);
            }
        }
    }
        //llenar al contrario
    public void fillBackwardsList(ListRutasPilas rutas){
        int size = rutas.size();
        Nodo []NodoArrayTemp = new Nodo[size];
        Nodo temp = rutas.getFirst();
        int i = 0;
        while(temp != null){
            NodoArrayTemp[i] = temp;
            i++;
            temp=temp.getNext();
        }
        for (int j = size-1; j > -1; j--){
            this.addElement(createNodo(NodoArrayTemp[j]));
        }
    }

    /***
     *
     * Otros métodos
     *
     */

        //Agregar a la pila
    public void addElement(RutaModel ruta){
        this.addElement(new Nodo(ruta.getId_ruta(), ruta.getMultimedia(), ruta.getId_usuario().getId_usuario(), ruta.getId_usuario().getUsuario(), ruta.getMe_gusta(), ruta.getUbicacion()));
    }

    public void addElement(Nodo nodo){
        if(this.first == null){
            nodo.setNext(null);
            this.first = this.last = nodo;
        } else {
            nodo.setNext(this.first);
            this.first = nodo;
        }
    }

        //Eliminar de la pila
    public void deleteElement(){
        if(this.first != null){
            if(this.first.getNext() != null){
                this.first = this.first.getNext();
            } else {
                this.first = this.last = null;
            }
        }
    }

        //mostrar pila
    public void showList(){
        Nodo temp = this.first;
        while(temp != null){
            System.out.print("["+temp.getId_usuario()+"]");
            temp = temp.getNext();
        }
        System.out.println("");
    }

        //ordenar mejor puntuada (inserción)
    public void sortingBestScored(){
        Nodo residue;
        Nodo selected = null;
        Nodo temp = this.first;
        int count = 0;
        while(temp != null){
            if(temp.getNext() != null && temp.getNext().getMe_gusta() > temp.getMe_gusta() ){
                //recorremos por segunda vez
                Nodo ResidueArrayTemp[] = new Nodo[count + 2];
                if(count == 0){
                    residue = this.createNodo(temp);
                    selected = this.createNodo(temp.getNext());
                    this.deleteElement();
                    this.deleteElement();
                    this.addElement(residue);
                    this.addElement(selected);
                    temp = selected;
                } else {
                    Nodo temp3 = this.first;
                    boolean bSelected = false;
                    //elimina el residuo y el seleccionado
                    for (int i = 0; i < (count + 2); i++){
                        if(!bSelected && temp.getNext().getMe_gusta() > temp3.getMe_gusta()){
                            ResidueArrayTemp[i] = this.createNodo(temp.getNext());
                            bSelected = true;
                            this.deleteElement();
                        } else {
                            ResidueArrayTemp[i] = this.createNodo(temp3);
                            Nodo aux = temp3.getNext();
                            this.deleteElement();
                            temp3 = aux;
                        }
                    }
                    //agrego el residuo
                    for (int i = (count+1); i > -1; i--){
                        this.addElement(ResidueArrayTemp[i]);
                    }
                    temp = ResidueArrayTemp[ResidueArrayTemp.length-2];
                }
            }
            count++;
            temp = temp.getNext();
        }
    }

    public Nodo[] getPila(int lim){
        Nodo temp[] = new Nodo[lim];
        Nodo NodoTemp = this.first;
        int i = 0;
        while(NodoTemp != null){
            temp[i] = this.createNodo(NodoTemp);
            i++;
            NodoTemp = NodoTemp.getNext();
        }
        return temp;
    }

    // otros métodos
    public Nodo createNodo(RutaModel temp){
        return new Nodo(
                temp.getId_ruta(),
                temp.getMultimedia(),
                temp.getId_usuario().getId_usuario(),
                temp.getId_usuario().getUsuario(),
                temp.getMe_gusta(),
                temp.getUbicacion()
        );
    }

    public Nodo createNodo(Nodo temp){
        return new Nodo(
                temp.getId_ruta(),
                temp.getMultimedia(),
                temp.getId_usuario(),
                temp.getUsuario(),
                temp.getMe_gusta(),
                temp.getUbicacion()
        );
    }

    public void checkLike(String id){

    }

    public int size(){
        int size = 0;
        Nodo temp = this.first;
        while(temp != null){
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    //getters y setters

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

