package com.saferide.saferide.services;

import com.saferide.saferide.models.HurtoModel;

import java.util.List;

public interface HurtoService {
    void saveHurto(HurtoModel hurto);//Create
    //No tengo ni la gran puta idea de como hacer esto.//Read
    void updateHurto(HurtoModel hurto);//Update
    void deleteHurto(String id_usuario);//Delete
}
