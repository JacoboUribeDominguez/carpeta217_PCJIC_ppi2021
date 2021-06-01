package com.saferide.saferide.repositories;

import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RutaRepository extends CrudRepository<RutaModel, String> {
    @Query(value = "SELECT ruta.id_ruta, ruta.multimedia, usuario.usuario AS id_usuario, ruta.me_gusta, ruta.ubicacion FROM ruta INNER JOIN usuario ON ruta.id_usuario = usuario.id_usuario", nativeQuery = true)
    Iterable<RutaModel> findAllRutes();
}
