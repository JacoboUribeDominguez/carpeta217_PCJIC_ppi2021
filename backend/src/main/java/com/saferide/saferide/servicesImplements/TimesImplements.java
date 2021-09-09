package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.helpers.Error;
import com.saferide.saferide.models.TimesModel;
import com.saferide.saferide.repositories.TimesRepository;
import com.saferide.saferide.services.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesImplements implements TimesService {

    @Autowired
    TimesRepository timesRepository;

    @Override
    public Error getMessage(TimesModel timesModel) {

        try{
            double sum = 0, average;
            int size = 0;
            for(TimesModel time : timesRepository.getTimes(timesModel.getId_metrica())){
                sum = sum + time.getTiempo();
                size++;
            }

            timesRepository.save(timesModel);

            if(size == 0){
                return new Error("First", 0);
            } else {
                average = sum / size;
                if(timesModel.getTiempo() >= average){
                    return new Error("Menor", 0);
                } else {
                    return new Error("Mayor", 0);
                }
            }

        } catch (Exception e){
            return new Error("hubo un error", 1);
        }
    }
}
