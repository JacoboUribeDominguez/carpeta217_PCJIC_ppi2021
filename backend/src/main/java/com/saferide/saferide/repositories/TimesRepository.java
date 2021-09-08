package com.saferide.saferide.repositories;

import com.saferide.saferide.models.TimesModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TimesRepository extends CrudRepository<TimesModel, Integer> {
    @Query(value = "SELECT * FROM tiempo_metrica WHERE id_metrica = ?1", nativeQuery = true)
    Iterable<TimesModel> getTimes(String id_metrica);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiempo_metrica WHERE id_metrica = ?1", nativeQuery = true)
    void deleteByIdMetrica(String id_metrica);
}
