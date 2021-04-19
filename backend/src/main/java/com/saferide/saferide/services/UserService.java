package com.saferide.saferide.services;

import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;

import java.util.List;

public interface UserService {

    List<UserModel>getUsers();
    UserModel saveUser(UserModel user);
}
