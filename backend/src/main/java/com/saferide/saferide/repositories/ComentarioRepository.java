package com.saferide.saferide.repositories;

import com.saferide.saferide.models.ComentarioModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ComentarioRepository extends CrudRepository<ComentarioModel, String> {
    @Query(value = "SELECT * FROM comentario WHERE id_ruta = ?1", nativeQuery = true)
    Iterable<ComentarioModel> findAllById(String id_ruta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM comentario WHERE id_ruta = ?1", nativeQuery = true)
    void deleteCommentByIdRuta(String id_ruta);
}
