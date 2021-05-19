package com.saferide.saferide.servicesImplements;

import com.saferide.saferide.functions.Functions;
import com.saferide.saferide.models.RutaModel;
import com.saferide.saferide.pilas.ListRutasPilas;
import com.saferide.saferide.repositories.RutaRepository;
import com.saferide.saferide.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<RutaModel> rutas = (List<RutaModel>) rutaRepository.findAll();
        rutas.get(rutas.size()-1).setMe_gusta(3);
        rutas.get(rutas.size()-2).setMe_gusta(7);

        ListRutasPilas pila = new ListRutasPilas();
        pila.fillList(rutas);
//        pila.showList();
        pila.sortingBestScored();
        pila.showList();
        return rutas;
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
