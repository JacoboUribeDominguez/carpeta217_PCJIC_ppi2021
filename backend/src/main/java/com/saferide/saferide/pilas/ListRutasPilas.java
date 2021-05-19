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
            this.addElement(
                    new Nodo(
                            rutas.get(i).getId_ruta(),
                            rutas.get(i).getMultimedia(),
                            rutas.get(i).getId_usuario(),
                            rutas.get(i).getMe_gusta(),
                            rutas.get(i).getUbicacion()
                    )
            );
        }
    }

        //llenar pila con otra pila
    public void fillList(ListRutasPilas rutas){
        Nodo temp = rutas.getFirst();
        while(temp != null){
            this.addElement(temp);
            temp = temp.getNext();
        }
    }

    /***
     *
     * Otros métodos
     *
     */

        //Agregar a la pila
    public void addElement(Nodo nodo){
        if(this.first == null){
            this.first = this.last = nodo;
        } else {
            nodo.setNext(this.first);
            this.first = nodo;
        }
    }

        //Eliminar de la pila
    public void deleteElement(Nodo nodo){
        Nodo temp = this.first;
        if(temp == nodo){
            this.first = temp.getNext();
        }
        while(temp != null){
            if(temp.getNext() != null){
                if(temp.getNext() == nodo){
                    temp.setNext(temp.getNext().getNext());
                    return;
                }
            }

            temp = temp.getNext();
        }
    }

        //mostrar pila
    public void showList(){
        Nodo temp = this.first;
        while(temp != null){
            System.out.print("["+temp.getMe_gusta()+"]");
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
                Nodo ResidueArrayTemp[] = new Nodo[count + 1];
                if(count == 0){
                    residue = new Nodo(
                            temp.getId_ruta(),
                            temp.getMultimedia(),
                            temp.getId_usuario(),
                            temp.getMe_gusta(),
                            temp.getUbicacion()
                    );
                    selected = new Nodo(
                            temp.getNext().getId_ruta(),
                            temp.getNext().getMultimedia(),
                            temp.getNext().getId_usuario(),
                            temp.getNext().getMe_gusta(),
                            temp.getNext().getUbicacion()
                    );
                    this.deleteElement(temp);
                    this.deleteElement(temp.getNext());
                    this.addElement(residue);
                    this.addElement(selected);
                    temp = selected;
                } else {
                    Nodo temp3 = this.first;
                    //elimina el residuo y el seleccionado
                    for (int i = 0; i < (count + 2); i++){
                        if(i == (count + 1)){
                            selected = new Nodo(
                                    temp3.getId_ruta(),
                                    temp3.getMultimedia(),
                                    temp3.getId_usuario(),
                                    temp3.getMe_gusta(),
                                    temp3.getUbicacion()
                            );
                            this.deleteElement(temp3);
                            break;
                        }
                        ResidueArrayTemp[i] = new Nodo(
                                temp3.getId_ruta(),
                                temp3.getMultimedia(),
                                temp3.getId_usuario(),
                                temp3.getMe_gusta(),
                                temp3.getUbicacion()
                        );
                        Nodo aux = temp3.getNext();
                        this.deleteElement(temp3);
                        temp3 = aux;
                    }
                    //imprimo el residuo
                    System.out.print("Residuo: ");
                    for (int i = 0; i < (count + 1); i++){
                        System.out.print("["+ResidueArrayTemp[i].getMe_gusta()+"]");
                    }
                    System.out.println("");
                    //agrego el residuo
                    System.out.print("Agregar: ");
                    for (int i = (count); i > -1; i--){
                        System.out.print("["+ResidueArrayTemp[i].getMe_gusta()+"]");
                        this.addElement(ResidueArrayTemp[i]);
                    }
                    System.out.println("");
                    System.out.print("Original: ");
                    //agrego el seleccionado
                    this.addElement(selected);
                    this.showList();
                    temp = ResidueArrayTemp[ResidueArrayTemp.length-2];
                }
            }
            count++;
            temp = temp.getNext();
        }
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

