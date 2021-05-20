package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.models.HurtoModel;
import com.saferide.saferide.repositories.HurtoRepository;
import com.saferide.saferide.services.HurtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HurtoImplements implements HurtoService {

    //Repositorio
    @Autowired
    private HurtoRepository hurtoRepository;

    //Traer el ID del Usuario

    @Autowired
    private UserImplements userImplements;

    @Override
    public void saveHurto(HurtoModel hurto) {
        Functions functions = new Functions();
        hurto.setId_hurto(functions.makeId());
        hurtoRepository.save(hurto);
    }

    @Override
    public List<HurtoModel> readHurtos() {
        return (List<HurtoModel>) hurtoRepository.findAll();
    }

    @Override
    public void updateHurto(HurtoModel hurto) {
        hurtoRepository.save(hurto);
    }

    @Override
    public void deleteHurto(String id_hurto) {
        hurtoRepository.deleteById(id_hurto);
    }


}
