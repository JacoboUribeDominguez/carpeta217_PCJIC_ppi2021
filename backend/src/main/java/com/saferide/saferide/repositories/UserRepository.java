package com.saferide.saferide.repositories;

import com.saferide.saferide.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findAll();
    UserModel save(UserModel user);
}

/*
package com.saferide.saferide.repositories;

import com.saferide.saferide.models.UserModel;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<UserModel, Integer> {
    List<UserModel> findAll();
}

 */