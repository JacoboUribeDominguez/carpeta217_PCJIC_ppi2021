package com.saferide.saferide.services;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.UserModel;

import java.util.List;

public interface UserService {
    //List<UserModel>getUsers(); //no se utilizará esta función.
    Error login(UserModel user);
}

