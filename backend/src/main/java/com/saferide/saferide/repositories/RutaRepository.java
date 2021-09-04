package com.saferide.saferide.repositories;

import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que extiende del CrudRepository que contiene funciones basicas para el funcionamiento
 * del backend
 * Observación: En la interfaz se hace el llamado de una Query.
 * Aparte de utilizar la funcion findResults pasandole como parametro
 * una palabra para realizar la busqueda de una ruta.
 */
public interface RutaRepository extends CrudRepository<RutaModel, String> {

    @Query(value = "SELECT * FROM ruta WHERE ruta.ubicacion LIKE %?1%", nativeQuery = true)
    Iterable<RutaModel> findResults(String palabra);
}
