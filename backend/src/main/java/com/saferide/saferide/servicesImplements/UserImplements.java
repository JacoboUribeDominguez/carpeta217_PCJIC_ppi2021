package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.models.UserModel;
import com.saferide.saferide.repositories.UserRepository;
import com.saferide.saferide.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class UserImplements implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*@Override
    public List<UserModel> getUsers(){
        return (List<UserModel>) userRepository.findAll();
    }*///No se utilizará esta función


    //Se define la función del servicio
    @Override
    public void saveUsers(UserModel userLog) {
        makeId(userLog);//Llamo la función para hacer la modificación de un usuario en especifico
        //userRepository.save(userLog);
    }

    //Funciones
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
        System.out.println(userLog.getId_usuario());
    }

}
