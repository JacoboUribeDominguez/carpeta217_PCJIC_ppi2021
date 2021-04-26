package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplements implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> getUsers(){
        return (List<UserModel>) userRepository.findAll();
    }

    @Override
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
}
