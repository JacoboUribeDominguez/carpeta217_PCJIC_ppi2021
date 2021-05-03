package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.helpers.Error;
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

    /*@Override
    public List<UserModel> getUsers(){
        return (List<UserModel>) userRepository.findAll();
    }*/
    //No se utilizará esta función

    public Error login(UserModel user){
        if (user.getCorreo().length() > 0 ){
            //Si el usuario envía un correo y lo encuentra va a verificar la contraseña y le mandará un mensaje sobre la verficación de esta (Error)
            UserModel foundUser = userRepository.findByCorreo(user.getCorreo());
            return checkUser(foundUser, user);
        } else {
            //En caso de que el usuario envíe un usuario y lo encuentra va a verificar la contraseña y le mandará un mensaje sobre la verficación de esta (Error)
            UserModel foundUser = userRepository.findByUsuario(user.getUsuario());
            return checkUser(foundUser, user);
        }
    }

    public Error checkUser(UserModel foundUser, UserModel user){
        if(foundUser != null){
            if (foundUser.getContraseña().equals(user.getContraseña())){
                return  new Error("Contraseña encontrada", 0);
            } else {
                return new Error("Contraseña o correo/usuario inválido", 1);
            }
        } else {
            return new Error("Contraseña o correo/usuario inválido", 1);
        }
    }
}


