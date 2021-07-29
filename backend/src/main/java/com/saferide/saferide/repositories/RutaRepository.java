package com.saferide.saferide.repositories;

import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RutaRepository extends CrudRepository<RutaModel, String> {

    @Query(value = "SELECT * FROM ruta WHERE ruta.ubicacion LIKE %?1%", nativeQuery = true)
    Iterable<RutaModel> findResults(String palabra);
}
