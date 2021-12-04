package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.*;

@Service
public class UserImplements implements UserService {

    //repositorio
    @Autowired
    private UserRepository userRepository;

    //login service

    @Override
    public Error login(UserModel user) {
        if (user.getCorreo().length() > 0) {
            //Si el usuario envía un correo y lo encuentra va a verificar la contraseña y le mandará un mensaje sobre la verficación de esta (Error)
            UserModel foundUser = userRepository.findByCorreo(user.getCorreo());
            return checkUser(foundUser, user);
        } else {
            //En caso de que el usuario envíe un usuario y lo encuentra va a verificar la contraseña y le mandará un mensaje sobre la verficación de esta (Error)
            UserModel foundUser = userRepository.findByUsuario(user.getUsuario());
            return checkUser(foundUser, user);
        }
    }

    //register service

    @Override
    public Error saveUsers(UserModel userLog) {
        //verificamos si el usuario ya esta registrado para evitar usuarios repetidos.
        if (userRepository.findByCorreo(userLog.getCorreo()) == null && userRepository.findByUsuario(userLog.getUsuario()) == null) {
            Functions functions = new Functions();
            userLog.setId_usuario(functions.makeId());//Llamo la función para hacer la modificación de un usuario en especifico (agrega id)
            userRepository.save(userLog); //Guarda en la base de datos
            return new Error(userLog.getId_usuario(), 0);
        } else {
            return new Error("Usuario ya registrado", 1);
        }
    }

    public Error checkUser(UserModel foundUser, UserModel user) {
        if (foundUser != null) {
            if (foundUser.getContraseña().equals(user.getContraseña())) {
                return new Error(foundUser.getId_usuario(), 0);
            } else {
                return new Error("Contraseña o correo/usuario inválido", 1);
            }
        } else {
            return new Error("Contraseña o correo/usuario inválido", 1);
        }
    }
}


