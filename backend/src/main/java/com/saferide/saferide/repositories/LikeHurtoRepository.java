package com.saferide.saferide.repositories;

import com.saferide.saferide.models.LikeHurtoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LikeHurtoRepository extends CrudRepository<LikeHurtoModel, Integer> {
    @Query(value = "DELETE FROM puntuacion_hurto WHERE id_hurto = ?1 AND id_usuario = ?2", nativeQuery = true)
    void deleteHurto(String id_hurto, String id_usuario);
}
