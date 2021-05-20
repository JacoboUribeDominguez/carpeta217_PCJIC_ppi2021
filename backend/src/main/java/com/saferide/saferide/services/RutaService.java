package com.saferide.saferide.services;

import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.Nodo;


public interface RutaService {
    void saveRuta(RutaModel ruta); //Create
    Nodo[] getRutas(); //Read
    void updateRuta(RutaModel ruta); //Update
    void deleteRuta(String id_ruta); //Delete
}
