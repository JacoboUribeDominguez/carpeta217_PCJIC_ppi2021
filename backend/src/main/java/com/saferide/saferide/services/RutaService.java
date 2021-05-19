package com.saferide.saferide.services;

import com.saferide.saferide.models.RutaModel;

import java.util.List;

public interface RutaService {
    void saveRuta(RutaModel ruta); //Create
    List<RutaModel> getRutas(); //Read
    void updateRuta(RutaModel ruta); //Update
    void deleteRuta(String id_ruta); //Delete
}
