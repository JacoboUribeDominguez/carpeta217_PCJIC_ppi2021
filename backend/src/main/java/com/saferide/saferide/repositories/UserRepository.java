package com.saferide.saferide.repositories;

import com.saferide.saferide.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}