package com.saferide.saferide.repositories;

import com.saferide.saferide.models.LikeRutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LikeRutaRepository extends CrudRepository<LikeRutaModel, Integer> {
    @Query(value = "SELECT * FROM puntuacion_ruta WHERE id_ruta = ?1 AND id_usuario = ?2", nativeQuery = true)
    Iterable<LikeRutaModel> existsRutes(String id_ruta, String id_usuario);

    @Query(value = "DELETE FROM puntuacion_ruta WHERE id_ruta = ?1 AND id_usuario = ?2", nativeQuery = true)
    void deleteRuta(String id_ruta, String id_usuario);
}
