package com.saferide.saferide.repositories;

import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RutaRepository extends CrudRepository<RutaModel, String> {

    @Query(value = "SELECT * FROM ruta WHERE ruta.ubicacion LIKE %?1%", nativeQuery = true)
    Iterable<RutaModel> findResults(String palabra);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ruta WHERE id_ruta = ?1", nativeQuery = true)
    void deleteById(String id_ruta);
}
