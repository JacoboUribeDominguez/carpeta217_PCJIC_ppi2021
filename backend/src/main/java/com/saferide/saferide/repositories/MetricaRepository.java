package com.saferide.saferide.repositories;

import com.saferide.saferide.colas.Nodo;
import com.saferide.saferide.models.MetricaModel;
import com.saferide.saferide.models.RutaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MetricaRepository extends CrudRepository<MetricaModel, String> {
    @Query(value = "SELECT * FROM metrica WHERE id_usuario = ?1", nativeQuery = true)
    Iterable<MetricaModel> findMetricas(String id_usuario);
}
