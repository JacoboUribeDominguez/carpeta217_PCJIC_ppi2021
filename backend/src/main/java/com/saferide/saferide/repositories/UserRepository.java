package com.saferide.saferide.repositories;

import com.saferide.saferide.models.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    @Query(value = "DELETE FROM usuario WHERE nombre = ?1", nativeQuery = true)
    void deleteUserByName(String nombre);
}