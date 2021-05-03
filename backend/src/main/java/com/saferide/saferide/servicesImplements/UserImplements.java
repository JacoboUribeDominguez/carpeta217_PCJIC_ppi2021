package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;
import com.saferide.saferide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class UserImplements implements UserService {
    @Autowired
    private UserRepository userRepository;

    //login service
    @Override
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

    //register service
    @Override
    public void saveUsers(UserModel userLog) {
        if (userRepository.findByCorreo(userLog.getCorreo()) == null && userRepository.findByUsuario(userLog.getUsuario()) == null) {
            makeId(userLog);//Llamo la función para hacer la modificación de un usuario en especifico
            userRepository.save(userLog);
        }
    }


    //Funciones de optimización
    public void makeId(UserModel userLog) {//Crea la id del modelo usuario
        String id;//Se inicializa la variable id
        LocalDate date = LocalDate.now();//Se llaman clases que generan una fecha (Year, Month, Day)
        String sDate = String.valueOf(date);//Se almacena la variable fecha en cadena
        LocalTime time = LocalTime.now();//Se llaman clases que generan una hora, minuto, segundo, milisegundo
        String sTime = String.valueOf(time);//Se almacena la variable tiempo en cadeana
        id = sDate + sTime;//Se concatenan las cadenas
        //Se eliminan caracteres innecesarios
        id = id.replace("-", "");
        id = id.replace(":", "");
        id = id.replace(".", "");
        userLog.setId_usuario(id);//Se coloca el id para el usuario en especifico
        //System.out.println(userLog.getId_usuario());
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


