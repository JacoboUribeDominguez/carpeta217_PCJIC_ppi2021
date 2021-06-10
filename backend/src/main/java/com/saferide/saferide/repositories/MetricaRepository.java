package com.saferide.saferide.repositories;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MetricaRepository extends CrudRepository<MetricaModel, String> {
    @Query(value = "SELECT r.ubicacion as ubicacion, u.usuario as usuario, r.me_gusta as me_gusta, r.multimedia as multimedia FROM metrica m INNER JOIN ruta r ON r.id_ruta = m.id_ruta INNER JOIN usuario u ON u.id_usuario = m.id_usuario WHERE m.id_usuario = ?1", nativeQuery = true)
    Iterable<Object> findMetricas(String id_usuario);
}
