package com.saferide.saferide.functions;

import com.saferide.saferide.models.UserModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class Functions {

    public Functions (){

    }

    public String makeId() {//Crea la id del modelo usuario
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
        return id;//Se retorna el id
    }


}
