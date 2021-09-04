package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.Nodo;

import java.util.List;

/**
 * Interfaz para el servicio de las rutas.
 * Observación: Llama ciertas funciones de la implementación
 * para poder realizar un correcto CRUD.
 */
public interface RutaService {
    /**
     * Guarda una ruta de tipo RutaModel
     *
     * @param ruta
     * @return
     */
    RutaModel saveRuta(RutaModel ruta); //Create

    /**
     * Hace funcion de obtenerRuta
     *
     * @param id
     * @return
     */
    Nodo[] getRutas(String id); //Read

    /**
     * Hace función para obtener un resultado
     * de rutas según una palabra
     *
     * @param palabra
     * @return
     */
    Nodo[] getResults(String palabra); //Read

    Error updateRuta(RutaModel ruta); //Update

    Error deleteRuta(String id_ruta); //Delete
}
