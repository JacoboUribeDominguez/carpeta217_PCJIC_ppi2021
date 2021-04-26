package com.saferide.saferide.controllers;

import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers(){
        return(userService.getUsers());
    }

    /*@PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return(userService.saveUser(user));
    }*/
}
