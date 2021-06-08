package com.saferide.saferide.services;

import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.Nodo;

import java.util.List;


public interface RutaService {
    RutaModel saveRuta(RutaModel ruta); //Create
    Nodo[] getRutas(); //Read
    List<RutaModel> getResults(String palabra); //Read
    void updateRuta(RutaModel ruta); //Update
    void deleteRuta(String id_ruta); //Delete
}
