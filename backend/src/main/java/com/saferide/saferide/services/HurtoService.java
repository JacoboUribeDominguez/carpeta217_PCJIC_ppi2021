package com.saferide.saferide.services;

import com.saferide.saferide.models.HurtoModel;

import java.util.List;

public interface HurtoService {
    void saveHurto(HurtoModel hurto);//Create

    List<HurtoModel> readHurtos();//Read

    void updateHurto(HurtoModel hurto);//Update

    void deleteHurto(String id_hurto);//Delete
}
