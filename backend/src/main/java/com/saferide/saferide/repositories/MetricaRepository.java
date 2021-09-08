package com.saferide.saferide.repositories;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MetricaRepository extends CrudRepository<MetricaModel, String> {
    @Query(value = "SELECT * FROM metrica WHERE id_usuario = ?1", nativeQuery = true)
    Iterable<MetricaModel> findMetricas(String id_usuario);

    @Query(value = "SELECT * from metrica WHERE id_ruta = ?1 AND id_usuario = ?2 ", nativeQuery = true)
    Iterable<MetricaModel> exists(String id_ruta, String id_usuario);

    @Query(value = "SELECT * FROM metrica where id_ruta = ?1", nativeQuery = true)
    Iterable<MetricaModel> findAllByIdRuta(String id_ruta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM metrica WHERE id_ruta = ?1", nativeQuery = true)
    void removeAllByIdRuta(String id_ruta);
}
