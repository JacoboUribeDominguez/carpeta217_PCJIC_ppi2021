package com.saferide.saferide.repositories;

import com.saferide.saferide.models.ComentarioModel;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<ComentarioModel, String> {
}
