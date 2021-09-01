package com.saferide.saferide.repositories;

import com.saferide.saferide.models.LikeSenderoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LikeSenderoRepository extends CrudRepository<LikeSenderoModel, Integer> {
    @Query(value = "DELETE FROM puntuacion_sendero WHERE id_sendero = ?1 AND id_usuario = ?2", nativeQuery = true)
    void deleteSendero(String id_sendero, String id_usuario);
}
