package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.UserModel;

import java.util.List;

public interface UserService {
    Error login(UserModel user);
    void saveUsers(UserModel userLog);//Se define la función vacia para trabajarla desde la implementación
}

