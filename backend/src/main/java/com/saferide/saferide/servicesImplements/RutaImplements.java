package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.listas.RutaList;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.repositories.RutaRepository;
import com.saferide.saferide.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaImplements implements RutaService {

    //repositorio
    @Autowired
    private RutaRepository rutaRepository;

    //usar makeId
    @Autowired
    private UserImplements userImplements;

    @Override
    public void saveRuta(RutaModel ruta) {
        Functions functions = new Functions();
        ruta.setId_ruta(functions.makeId());
        ruta.setMe_gusta(0);
        rutaRepository.save(ruta);
    }

    @Override
    public List<RutaModel> getRutas() {
//        List<RutaModel> rutas = (List<RutaModel>) rutaRepository.findAll();
//        for (int i = 0; i < rutas.size(); i++){
//            System.out.println(rutas.get(i));
//        }
        RutaList rl = new RutaList();
        rl.fillList((List<RutaModel>) rutaRepository.findAll());
        rl.showList();
        return (List<RutaModel>) rutaRepository.findAll();
    }

    @Override
    public void updateRuta(RutaModel ruta){
        rutaRepository.save(ruta);
    }

    @Override
    public void deleteRuta(String id_ruta){
        rutaRepository.deleteById(id_ruta);
    }

    //métodos

}
