package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.Nodo;

import java.util.List;


public interface RutaService {
    RutaModel saveRuta(RutaModel ruta); //Create
    Nodo[] getRutas(String id); //Read
    Nodo[] getResults(String palabra); //Read
    Error updateRuta(RutaModel ruta); //Update
    Error deleteRuta(String id_ruta); //Delete
}
