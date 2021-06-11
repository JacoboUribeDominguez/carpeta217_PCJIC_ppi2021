package com.saferide.saferide.repositories;

import com.saferide.saferide.models.TimesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TimesRepository extends CrudRepository<TimesModel, Integer> {
    @Query(value = "SELECT * FROM tiempo_metrica WHERE id_metrica = ?1", nativeQuery = true)
    Iterable<TimesModel> getTimes(String id_metrica);

}
